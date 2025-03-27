package com.example.JobPortal.controller;


import com.example.JobPortal.entity.RecruiterProfile;
import com.example.JobPortal.entity.Users;
import com.example.JobPortal.repository.UsersRepository;
import com.example.JobPortal.services.RecruiterProfileService;
import com.example.JobPortal.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {

    private final UsersRepository usersRepository;
    private final RecruiterProfileService recruiterProfileService;

    public RecruiterProfileController(UsersRepository usersRepository,RecruiterProfileService recruiterProfileService) {
        this.usersRepository = usersRepository;
        this.recruiterProfileService = recruiterProfileService;
    }

    @GetMapping("/")
    public String recruiterProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUsername = authentication.getName();
            Users users = usersRepository.findByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Could not " +
                    "found the user"));
            Optional<RecruiterProfile> recruiterProfile = recruiterProfileService.getOne(users.getUserId());

            if(!recruiterProfile.isEmpty()){
                model.addAttribute("profile",recruiterProfile.get());
            }
        }
        return  "recruiter_profile";
    }

    @PostMapping("/addNew")
    public String addNew(@ModelAttribute RecruiterProfile recruiterProfile,
                         @RequestParam("image") MultipartFile multipartFile,
                         Model model, RedirectAttributes redirectAttributes) {

        // Get authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            Users users = usersRepository.findByEmail(currentUsername)
                    .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));

            recruiterProfile.setUserId(users);
            recruiterProfile.setUserAccountId(users.getUserId());
        }

        model.addAttribute("profile", recruiterProfile);

        // File upload validation
        final long MAX_FILE_SIZE = 2 * 1024 * 1024;  // 2MB
        String fileName = "";

        if (!multipartFile.isEmpty()) {
            fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

            // Validate file size
            if (multipartFile.getSize() > MAX_FILE_SIZE) {
                model.addAttribute("errorMessage", "File size exceeds 2MB limit.");
                return "recruiter_profile";

            }

            // Validate file type (allow only images)
            String contentType = multipartFile.getContentType();
            if (contentType == null || (!contentType.equals("image/jpeg") && !contentType.equals("image/png") && !contentType.equals("image/gif"))) {
                model.addAttribute("errorMessage", "Invalid file type. Only JPG, PNG, and GIF are allowed.");
                return "recruiter_profile";
            }

            recruiterProfile.setProfilePhoto(fileName);
        }

        // Save recruiter profile
        RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

        // Upload file if exists
        if (!multipartFile.isEmpty()) {
            String uploadDir = "photos/recruiter/" + savedUser.getUserAccountId();
            try {
                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            } catch (IOException ex) {
                model.addAttribute("errorMessage", "File upload failed. Please try again.");
                return "recruiter_profile";
            }
        }
        return "redirect:/dashboard/";
    }
}

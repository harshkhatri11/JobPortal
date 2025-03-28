# 🚀 Job Portal Application

**Job Portal** is a robust **Spring Boot MVC-based web application** designed to bridge the gap between **job seekers** and **recruiters**, offering a seamless and efficient recruitment experience. The platform empowers job seekers to **explore** opportunities, **submit applications**, and showcase their professional profiles, while recruiters can efficiently manage **job postings**, **track applicants**, and streamline the hiring process.

## 🌟 **Features**
✅ **Job Seeker Features**  
- Register and login to the portal  
- Fill in personal details with **profile photo upload**  
- Add **skills & resume**  
- Apply for **multiple job postings**  
- Save jobs for future applications  

✅ **Recruiter Features**  
- Register and login as a recruiter  
- Post new job openings  
- View applicants who applied for a job  
- Download resumes of job seekers  

✅ **General Features**  
- **MVC architecture** using Spring Boot  
- **Thymeleaf templating engine** for dynamic web pages  
- **SQL database** for storing job and user details  
- **File Upload** functionality for profile images and resumes  

---

## 🛠️ Technologies Used

### 🎯 **Backend**
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen?style=for-the-badge&logo=springboot)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-Architecture-blue?style=for-the-badge)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-orange?style=for-the-badge)

### 🎨 **Frontend**
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template%20Engine-blue?style=for-the-badge)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.0-purple?style=for-the-badge)
![HTML5](https://img.shields.io/badge/HTML5-Markup-orange?style=for-the-badge)
![CSS3](https://img.shields.io/badge/CSS3-Styling-blue?style=for-the-badge)

### 🗄️ **Database**
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-green?style=for-the-badge)

![Image](src/main/resources/static/assets/jobportal_diagram.png)


### 🚀 **DevOps & Deployment**
![GitHub](https://img.shields.io/badge/GitHub-Code%20Hosting-black?style=for-the-badge&logo=github)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red?style=for-the-badge&logo=apache-maven)


### 🔧 **Tools & Version Control**
![Git](https://img.shields.io/badge/Git-Version%20Control-orange?style=for-the-badge&logo=git)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-Java%20IDE-red?style=for-the-badge&logo=intellij-idea)



## 🚀 **Installation & Setup**
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/harshkhatri11/JobPortal.git
cd job-portal
```

### **2️⃣  Configure the Database**
 Update the `application.properties` file with your database   credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobPortal
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```

### **3️⃣ Run the Application**
```sh
./mvnw spring-boot:run
```

Once the application starts, open your browser and visit:
```sh
http://localhost:8080
```

# Job Portal Home Page


![Image](src/main/resources/static/assets/JobPortal_app_homepage.png)



# Job Seeker


![Image](src/main/resources/static/assets/Job_seeker_landing_page.png)

![Image](src/main/resources/static/assets/Job_seeker_profile.png)

![Image](src/main/resources/static/assets/Job_seeker_view_detail_job_desc.png)



# Recruiter


![Image](src/main/resources/static/assets/Recruiter_landing_page.png)

![Image](src/main/resources/static/assets/Recruiter_post_new_job.png)

![Image](src/main/resources/static/assets/Recruiter_posted_job_view.png)



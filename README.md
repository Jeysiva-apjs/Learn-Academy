![3](https://github.com/Jeysiva-apjs/LearnAcademy/assets/126048586/ed1f579e-2155-4e38-9dd6-b61eeb534b40)

Lear Academy is a learning platform facilitating user registration, course management, and enrollment.


## Admin Dashboard
1. The admin side of the course selling app.
2. Admins can log in or register a new account.
3. All admins have the power to:
    ✅ CREATE courses
    ✏️ UPDATE courses
    ❌ DELETE courses

## User Dashboard
1. The user side of the course-selling app
2. Users can log in or register a new account.
3. Users get access to a wide range of courses created by Admins.
4. Users can purchase their preferred courses!

## Built With 
1. Java
2. Spring Boot
3. Junit
4. Mockito

## Admin Endpoints

### Create Admin
- URL: `/admin/signup`
- Description: Creates a new admin account.
- Input: JSON body with admin details (name, email, password).
- Output: Success message.

### Admin Login
- URL: `/admin/login`
- Description: Logs in an admin.
- Input: JSON body with admin credentials (email, password).
- Output: Success message.

### Create Course
- URL: `/admin/courses/create/{adminId}`
- Description: Creates a new course.
- Input: JSON body with course details (title, description, price, isPublished).
- Output: Success message.

### Update Course
- URL: `/admin/courses/update/{courseId}`
- Description: Updates an existing course.
- Input: JSON body with updated course details (title, description, price, isPublished).
- Output: Success message.

### Delete Course
- URL: `/admin/courses/delete/{courseId}`
- Description: Deletes a course.
- Input: Course ID.
- Output: Success message.

### Get All Courses
- URL: `/admin/courses/all`
- Description: Retrieves all courses.
- Input: None.
- Output: List of courses.

## User Endpoints

### User Signup
- URL: `/user/signup`
- Description: Creates a new user account.
- Input: JSON body with user details (name, email, password).
- Output: Success message.

### User Login
- URL: `/user/login`
- Description: Logs in a user.
- Input: JSON body with user credentials (email, password).
- Output: Success message.

### Get All Courses
- URL: `/user/courses/all`
- Description: Retrieves all courses.
- Input: None.
- Output: List of courses.

### Purchase Course
- URL: `/user/{userId}/purchaseCourses/{courseId}`
- Description: Purchases a course for a user.
- Input: User ID, Course ID.
- Output: Success message.

### Get Purchased Courses
- URL: `/user/{userId}/purchasedCourses`
- Description: Retrieves purchased courses for a user.
- Input: User ID.
- Output: Set of purchased courses.

   

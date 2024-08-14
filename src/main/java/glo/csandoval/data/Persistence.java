package glo.csandoval.data;

public class Persistence {
    public static void initializeData() {
        // String name, double baseSalary, int experienceInYears, int activeHoursPerWeek
        University.addTeacher(new PartTimeTeacher("Guillermo F. Simons", 3500.0, 0, 22));
        University.addTeacher(new PartTimeTeacher("Harrison D. Grant", 3820.0, 1, 25));
        University.addTeacher(new FullTimeTeacher("Wilbur C. Whatley", 4204.0, 4, 40));
        University.addTeacher(new FullTimeTeacher("Daniel D. Moore", 6204.0, 15, 42));

        // String name, int age
        University.addStudent(new Student("Robert P. Bates", 20));
        University.addStudent(new Student("Stacey K. Hamilton", 21));
        University.addStudent(new Student("William L. Bowman", 28));
        University.addStudent(new Student("Kerry E. Merriman", 32));
        University.addStudent(new Student("Christine A. Brown", 24));
        University.addStudent(new Student("Gabbs G. Rarham", 21));

        // String name, String classroom
        University.addCourse(new Course("Algorithms", "304"));
        University.addCourse(new Course("Economic Analysis for Business Decisions", "201"));
        University.addCourse(new Course("Communication for Managers", "202"));
        University.addCourse(new Course("Mathematics for Computer Science", "523"));

        int i = 0;
        for (Course course : University.getAllCourses()) {
            if (i % 2 == 0) {
                course.addStudent(University.getAllStudents().get(0));
                course.addStudent(University.getAllStudents().get(2));
                course.addStudent(University.getAllStudents().get(4));

                course.addTeacher(University.getAllTeachers().get(0));
                course.addTeacher(University.getAllTeachers().get(2));
            } else {
                course.addStudent(University.getAllStudents().get(1));
                course.addStudent(University.getAllStudents().get(3));
                course.addStudent(University.getAllStudents().get(5));

                course.addTeacher(University.getAllTeachers().get(1));
                course.addTeacher(University.getAllTeachers().get(3));
            }
            i++;
        }
    }
}

package glo.csandoval;

import glo.csandoval.data.*;
import glo.csandoval.ui.utilities.SafeInput;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) {
        try {
            Persistence.initializeData();
        } catch (OperationNotSupportedException e) {
            System.out.println("Critical error when loading initialization data!");
            System.exit(-1);
        }

        Main.initialMenu();
        while (Main.mainMenu() >= 0)
            ; // Run main menu while the user does not exit the program (mainMenu returns -1 in exit option)
    }

    private static void showCourseDataByIndex(int index) {
        if (index == -1)
            return;

        Course selectedCourse = University.getAllCourses().get(index);
        if (selectedCourse == null)
            System.out.println("Invalid course!");
        else
            System.out.println(selectedCourse.getDetailedCourseData());
    }

    private static void showAllTeachers() {
        int i = 1;
        for (Teacher teacher: University.getAllTeachers()) {
            System.out.println(i + ". " + teacher.toString());
            i++;
        }
    }

    private static void showAllCourses() {
        int i = 1;
        for (Course course: University.getAllCourses()) {
            System.out.println(i + ". " + course.toString());
            i++;
        }
    }

    private static void showAllClassesOfStudent(Student student) {}

    private static Student selectStudentMenu() {return null;}

    private static int selectCourseByIndexMenu() {
        Main.showAllCourses();
        System.out.println("Select which course you want to select (0 to exit):");

        Integer courseVisualId = null; // Visual Id = List index + 1
        boolean isFirstAttempt = true;
        while (courseVisualId == null || courseVisualId < 0 || courseVisualId > University.getAllCourses().size()) {
            if (!isFirstAttempt)
                System.out.println("The selected id is invalid! Try again.");

            courseVisualId = SafeInput.getIntegerFromInput(System.in);
            isFirstAttempt = false;
        }
        return (courseVisualId - 1); // Return List index or -1 if user selects exit
    }

    private static Course createClassMenu() {return null;}

    private static Student createStudent() {
        String studentName = "";
        boolean isFirstAttempt = true;
        while (studentName == null || studentName.isEmpty()) {
            if (!isFirstAttempt)
                System.out.println("The name cannot be empty! Try again.");

            System.out.println("Please enter the new student name:");
            studentName = SafeInput.getStringFromSource(System.in);
            isFirstAttempt = false;
        }

        Integer studentAge = -1;
        isFirstAttempt = true;
        while (studentAge == null || studentAge < 0) {
            if (!isFirstAttempt)
                System.out.println("The enter age is invalid! Try again.");

            System.out.println("Please enter the age of the student:");
            studentAge = SafeInput.getIntegerFromInput(System.in);
            isFirstAttempt = false;
        }

        University.addStudent(studentName, studentAge);
        return University.getAllStudents().get(University.getAllStudents().size() - 1);
    }

    private static void addStudentToCourseMenu(Student student) {
        System.out.println("To which class do you want to add the student you just created?");
        Main.showAllCourses();
        System.out.println("Select which course you want to add student (0 to exit):");

        Integer courseVisualId = null; // Visual Id = List index + 1
        boolean isFirstAttempt = true, repeatMenu = true;
        while (courseVisualId == null || courseVisualId < 0 || courseVisualId > University.getAllCourses().size()) {
            if (!isFirstAttempt)
                System.out.println("The selected id is invalid! Try again.");

            courseVisualId = SafeInput.getIntegerFromInput(System.in);
            isFirstAttempt = false;
        }

        if (courseVisualId == 0)
            return;
        try {
            University.addStudentToCourse(student, University.getAllCourses().get(courseVisualId - 1));
        } catch (OperationNotSupportedException e) {
            System.out.println("The student already belongs to this class!");
        } catch (IllegalArgumentException e) {
            System.out.println("The registered parameters are invalid!");
            return;
        }
        Main.addStudentToCourseMenu(student); // Recursion (I know it's not the best in terms of performance, but I want to keep it simple.)
    }

    private static void addStudentToCourseMenu(Course course) {}
    private static void addTeacherToCourseMenu(Course course) {}

    private static int mainMenu() {
        System.out.println("\n1. Show all teachers\n" +
                "2. Show course data\n" +
                "3. Create student\n" +
                "4. Create course\n" +
                "5. Show classes of student\n" +
                "6. Exit\n" +
                "Please select an option:");
        Integer userOption = SafeInput.getIntegerFromInput(System.in);
        if (userOption == null) {
            System.out.println("Invalid option!");
            return 0;
        }

        switch (userOption) {
            case 1:
                Main.showAllTeachers();
                break;
            case 2:
                int index = Main.selectCourseByIndexMenu();
                Main.showCourseDataByIndex(index);
                break;
            case 3:
                Student newStudent = Main.createStudent();
                Main.addStudentToCourseMenu(newStudent);
                break;
            case 4:
                Course newCourse = Main.createClassMenu();
                Main.addStudentToCourseMenu(newCourse);
                Main.addTeacherToCourseMenu(newCourse);
                break;
            case 5:
                Student student = Main.selectStudentMenu();
                Main.showAllClassesOfStudent(student);
                break;
            case 6:
                System.out.println("Goodbye, thank you for use our software!");
                return -1;
            default:
                System.out.println("Unknown option! Please try again.");
                break;
        }
        return 0;
    }

    private static void initialMenu() {
        System.out.println("Welcome to Globant University Manager\n\nRegister the university name: ");

        String name = null;
        boolean isFirstAttempt = true;
        while (name == null || name.isEmpty()) {
            if (!isFirstAttempt)
                System.out.println("Please enter a valid name!");
            name = SafeInput.getStringFromSource(System.in);
            isFirstAttempt = false;
        }

        University.setName(name);
    }
}
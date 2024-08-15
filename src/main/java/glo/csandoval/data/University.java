package glo.csandoval.data;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

// Static attributes are implemented since only 1 university is managed at the problem boundary.
// So this solution maintains the logic and eliminates the need for an instance.
public class University {
    private static String name;
    private static List<Course> courses = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static String getName() {
        return University.name;
    }

    public static void setName(String newName) throws IllegalArgumentException {
        if (newName == null || newName.isEmpty())
            throw new IllegalArgumentException("University: The new name is null or is empty");
        University.name = newName;
    }

    public static List<Course> getAllCourses() {
        return new ArrayList<>(University.courses);
    }

    public static void addCourse(Course newCourse) throws NullPointerException {
        if (newCourse == null)
            throw new NullPointerException("University: Add null class into the list");
        University.courses.add(newCourse);
    }

    public static Course addCourse(String name, String classroom) throws IllegalArgumentException {
        if (name == null || classroom == null || name.isEmpty() || classroom.isEmpty())
            throw new IllegalArgumentException("University: Add null class into the list");
        Course newCourse = new Course(name, classroom);
        University.courses.add(newCourse);
        return newCourse;
    }

    public static void removeCourse(Course courseToRemove) throws IllegalArgumentException {
        if (courseToRemove == null || !University.courses.contains(courseToRemove))
            throw new IndexOutOfBoundsException("University: The indicated course is null or not exits");
        University.courses.remove(courseToRemove);
    }

    public static List<Teacher> getAllTeachers() {
        return new ArrayList<>(University.teachers);
    }

    public static void addTeacher(Teacher newTeacher) throws NullPointerException {
        if (newTeacher == null)
            throw new NullPointerException("University: Add null teacher into the list");
        University.teachers.add(newTeacher);
    }

    public static void removeTeacher(Teacher teacherToRemove) throws IllegalArgumentException {
        if (teacherToRemove == null || !University.teachers.contains(teacherToRemove))
            throw new IllegalArgumentException("University: The indicated teacher is null or not exits");

        for (Course course : University.courses) {
            course.removeTeacher(teacherToRemove);
        }
    }

    public static void addTeacherToCourse(Teacher teacher, Course course) throws IllegalArgumentException, OperationNotSupportedException {
        if (!University.courses.contains(course) || !University.teachers.contains(teacher))
            throw new IllegalArgumentException("University: Teacher or Course no exists");

        course.addTeacher(teacher);
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(University.students);
    }

    public static void addStudent(Student newStudent) throws NullPointerException {
        if (newStudent == null)
            throw new NullPointerException("University: Add null student into the list");
        University.students.add(newStudent);
    }

    public static Student addStudent(String name, int age) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || age < 0)
            throw new IllegalArgumentException("University: Add null student into the list");

        Student newStudent = new Student(name, age);
        University.students.add(newStudent);
        return newStudent;
    }

    public static void removeStudent(Student studentToRemove) throws IllegalArgumentException, OperationNotSupportedException {
        if (studentToRemove == null || !University.students.contains(studentToRemove))
            throw new IllegalArgumentException("University: The indicated student is null or not exits");

        for (Course course : University.courses) {
            course.removeStudent(studentToRemove);
        }
    }

    public static void addStudentToCourse(Student student, Course course) throws IllegalArgumentException, OperationNotSupportedException {
        if (!University.courses.contains(course) || !University.students.contains(student))
            throw new IllegalArgumentException("University: Student or Course no exists");

        course.addStudent(student);
    }
}

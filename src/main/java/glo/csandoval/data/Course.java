package glo.csandoval.data;

import java.util.*;

public class Course {
    private String name;
    private String classroom;
    private final List<Student> students;
    private final List<Teacher> teachers;

    // A set of identifiers is used to speed up the validation of whether you are enrolled in the course.
    // It does not apply to teachers because their growth is not equal to the number of students.
    private final Set<UUID> enrolledStudentsUUID = new HashSet<>();

    public Course(String name, String classroom) throws IllegalArgumentException {
        if (name == null || classroom == null || name.isEmpty() || classroom.isEmpty())
            throw  new IllegalArgumentException("Class_Constructor: Invalid information for university class creation process");
        this.name = name;
        this.classroom = classroom;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException {
        if (newName == null || newName.isEmpty())
            throw new IllegalArgumentException("Class_Name: The new name is null or is empty");
        this.name = newName;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String newClassroom) throws IllegalArgumentException {
        if (newClassroom == null || newClassroom.isEmpty())
            throw new IllegalArgumentException("Class_Classroom: The new classroom name is null or is empty");
        this.classroom = newClassroom;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void addStudent(Student newStudent) throws IllegalArgumentException {
        if (newStudent == null)
            throw new IllegalArgumentException("Class_StudentList: An attempt was made to add an invalid item to the list of students.");
        if (this.enrolledStudentsUUID.contains(newStudent.getId()))
            throw new IllegalArgumentException("Class_StudentList: An attempt was made to add an duplicated item to the list of students.");

        this.students.add(newStudent);
        this.enrolledStudentsUUID.add(newStudent.getId());
    }

    public void removeStudent(Student student) throws IllegalArgumentException {
        if (student == null)
            throw new IllegalArgumentException("Class_StudentList: An attempt was made to remove an invalid item to the list of students.");
        if (!this.enrolledStudentsUUID.contains(student.getId()))
            throw new IllegalArgumentException("Class_StudentList: An attempt was made to remove an non-existing item to the list of students.");

        this.students.remove(student);
        this.enrolledStudentsUUID.remove(student.getId());
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(this.teachers);
    }

    public void addTeacher(Teacher newTeacher) throws IllegalArgumentException {
        if (newTeacher == null)
            throw new IllegalArgumentException("Class_TeacherList: An attempt was made to add an invalid item to the list of teachers.");
        if (this.teachers.contains(newTeacher))
            throw new IllegalArgumentException("Class_TeacherList: An attempt was made to add an duplicated item to the list of teachers.");

        this.teachers.add(newTeacher);
    }

    public void removeTeacher(Teacher teacher) throws IllegalArgumentException {
        if (teacher == null)
            throw new IllegalArgumentException("Class_TeacherList: An attempt was made to remove an invalid item to the list of teachers.");
        if (!this.teachers.contains(teacher))
            throw new IllegalArgumentException("Class_TeacherList: An attempt was made to remove an non-existing item to the list of teachers.");

        this.teachers.remove(teacher);
    }

    @Override
    public String toString() {
        return ("Name: " + this.name
                + " | Classroom: " + this.classroom);
    }

    public String getDetailedCourseData() {
        StringBuilder str = new StringBuilder();
        str.append(this.toString());

        str.append("\nStudents: ");
        for (Student student : this.students) {
            str.append("\n\t").append("* ").append(student.toString());
        }

        str.append("\nTeachers: ");
        for (Teacher teacher : this.teachers) {
            str.append("\n\t").append("* ").append(teacher.toString());
        }

        return str.toString();
    }
}

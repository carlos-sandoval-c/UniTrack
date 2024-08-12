package glo.csandoval.data;

import java.util.UUID;

public class Student {
    private final UUID id;
    private String name;
    private int age;

    public Student(String name, int age) throws IllegalArgumentException{
        if (name == null || name.isEmpty() || age < 0)
            throw new IllegalArgumentException("Student_Constructor: Invalid information for student creation process");

        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException {
        if (newName == null || newName.isEmpty())
            throw new IllegalArgumentException("Student_Name: The new name is null or is empty");
        this.name = newName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) throws IllegalArgumentException {
        if (newAge < 0)
            throw new IllegalArgumentException("Student_Age: Invalid age");
        this.age = newAge;
    }
}

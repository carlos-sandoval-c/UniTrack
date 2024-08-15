package glo.csandoval.data;

public abstract class Teacher {
    private String name;
    private double baseSalary;
    private int experienceInYears;
    private int activeHoursPerWeek;

    public Teacher(String name, double baseSalary, int experienceInYears, int activeHoursPerWeek) throws IllegalArgumentException{
        if (name == null || name.isEmpty() || baseSalary < 0.0 || experienceInYears < 0 || activeHoursPerWeek < 0)
            throw new IllegalArgumentException("Teacher_Constructor: Invalid information for teacher creation process");

        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceInYears = experienceInYears;
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws IllegalArgumentException {
        if (newName == null || newName.isEmpty())
            throw new IllegalArgumentException("Student_Name: The new name is null or is empty");
        this.name = newName;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double newBaseSalary) {
        this.baseSalary = newBaseSalary;
    }

    public int getActiveHoursPerWeek() {
        return this.activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(int newActiveHoursPerWeek) {
        this.activeHoursPerWeek = newActiveHoursPerWeek;
    }

    public int getExperienceInYears() {
        return this.experienceInYears;
    }

    public void setExperienceInYears(int newExperienceInYears) {
        this.experienceInYears = newExperienceInYears;
    }

    public abstract double getSalary();

    @Override
    public String toString() {
        return ("Name: " + this.name
                + " | Base Salary:" + this.baseSalary
                + " | Years of Experience: " + this.experienceInYears
                + " | Active hours per week: " + this.activeHoursPerWeek);
    }
}

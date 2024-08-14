package glo.csandoval.data;

public class FullTimeTeacher extends Teacher {
    public FullTimeTeacher(String name, double baseSalary, int experienceInYears, int activeHoursPerWeek) throws IllegalArgumentException {
        super(name, baseSalary, experienceInYears, activeHoursPerWeek);
    }

    public double getSalary() {
        // base salary (attribute) multiplied by 110% of its experience years.
        return (super.getBaseSalary() * (super.getExperienceInYears() * 1.10));
    }
}

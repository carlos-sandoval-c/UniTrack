package glo.csandoval.data;

public class PartTimeTeacher extends Teacher{
    public PartTimeTeacher(String name, double baseSalary, int experienceInYears, int activeHoursPerWeek) throws IllegalArgumentException {
        super(name, baseSalary, experienceInYears, activeHoursPerWeek);
    }

    public double getSalary() {
        return (super.getBaseSalary() * super.getActiveHoursPerWeek());
    }
}

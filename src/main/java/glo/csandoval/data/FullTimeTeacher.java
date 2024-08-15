package glo.csandoval.data;

public class FullTimeTeacher extends Teacher {
    public FullTimeTeacher(String name, double baseSalary, int experienceInYears, int activeHoursPerWeek) throws IllegalArgumentException {
        super(name, baseSalary, experienceInYears, activeHoursPerWeek);
    }

    public double getSalary() {
        return Math.round(super.getBaseSalary() * (super.getExperienceInYears() * 1.10));
    }

    @Override
    public String toString() {
        return super.toString() + (" | Calculated Salary:" + this.getSalary());
    }
}

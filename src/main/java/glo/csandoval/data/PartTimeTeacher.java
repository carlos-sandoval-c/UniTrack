package glo.csandoval.data;

public class PartTimeTeacher extends Teacher{
    public PartTimeTeacher(String name, double baseSalary, int experienceInYears, int activeHoursPerWeek) throws IllegalArgumentException {
        super(name, baseSalary, experienceInYears, activeHoursPerWeek);
    }

    public double getSalary() {
        return Math.round(super.getBaseSalary() * super.getActiveHoursPerWeek());
    }

    @Override
    public String toString() {
        return super.toString() + (" | Calculated Salary:" + this.getSalary());
    }
}

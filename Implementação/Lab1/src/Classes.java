public class Classes {
    private int id;
    private int registeredStudents;
    private int period;
    private int hours;
    private boolean status;
    private double hourPrice;

    Classes(int id, int registeredStudents, int period, int hours, boolean status, double hourPrice) {
        this.id = id;
        this.registeredStudents = registeredStudents;
        this.period = period;
        this.hours = hours;
        this.status = status;
        this.hourPrice = hourPrice;
    }

    public Classes getClasses() {
        return this;
    }
}

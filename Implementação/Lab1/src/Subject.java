import java.util.Date;
import java.util.List;

public class Subject {
    protected int id;
    protected String name;
    private List<Integer> registered_students;
    protected int period;
    protected int hours;
    protected boolean status;
    protected double hourPrice;
    protected int teacher;
    protected Date registry_start_date;
    protected Date registry_end_date;

    Subject(int id, String name, List<Integer> registered_students, int period, int hours, boolean status, double hourPrice, int teacher, Date registry_start_date, Date registry_end_date) {
        this.id = id;
        this.name = name;
        this.registered_students = registered_students;
        this.period = period;
        this.hours = hours;
        this.status = status;
        this.hourPrice = hourPrice;
        this.teacher = teacher;
        this.registry_start_date = registry_start_date;
        this.registry_end_date = registry_end_date;
    }

    public static Subject getById(int id) {
        return Database.Subjects.stream()
                .filter(subject -> subject.id == id)
                .toList().get(0);
    }

    public List<Integer> getRegisteredStudents() {
        return this.registered_students;
    }

    public boolean isStudentRegistered(int student_id) {
        return this.registered_students.contains(student_id);
    }

    public void addStudent(int student_id) throws Exception {
        if (!this.isInRegistryPeriod()) {
            throw new Exception("This subject is not in registry period anymore.");
        }
        if (this.registered_students.size() == 60) {
            throw new Exception("This subject can't accept new registries.");
        }

        int found = this.registered_students.indexOf(student_id);
        if (found == -1) {
            this.registered_students.add(student_id);
        } else {
            throw new Exception("Student is already registered in this subject.");
        }
    }

    public void rmStudent(int student_id) throws Exception {
        int found = this.registered_students.indexOf(student_id);
        if (found != -1) {
            this.registered_students.remove(found);
        } else {
            throw new Exception("Student does not have registry in this subject.");
        }
    }

    public void setNewRegistryDates(Date start_date, Date end_date) {
        this.registry_start_date = start_date;
        this.registry_end_date = end_date;
    }

    public boolean isInRegistryPeriod() {
        Date now = new Date();
        if (now.after(this.registry_start_date) && now.before(this.registry_end_date)) {
            return true;
        }
        return false;
    }

    public Subject getSubject() {
        return this;
    }
}

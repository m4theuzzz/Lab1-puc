import java.util.*;

public class Student extends User {
    protected int period;

    Student(int id, String name, String email, String password, int period) {
        super(id, name, email, password);
        this.period = period;
    }

    public static Student getById(int id) {
        return Database.Users.stream()
                .filter(user -> user.getClass() == Student.class && user.id == id)
                .map(user -> (Student) user)
                .toList().get(0);
    }

    public void makeRegistry(int subject_id) {
        int id = Database.Registries.get(Database.Users.size() - 1).id + 1;
        Registry registry = new Registry(id, subject_id, this.id);
        Database.Registries.add(registry);
    }

    public void cancelRegistry(int registry_id) {
    }

    public List<Registry> getRegistries() {
        return Database.Registries.stream().filter(registry -> registry.student_id == this.id).toList();
    }

    private Grade getGrade() {
        return Database.Grades.stream().filter(grade -> grade.period == this.period).toList().get(0);
    }

    public boolean validateMandatoryRegistries() {
        Grade grade = getGrade();

        return true;
    }

    public boolean validateTotalRegistries() {
        return true;
    }

    public boolean validateOptionalRegistries() {
        return true;
    }

}

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

    public void makeRegistry(int subject_id) throws Exception {
        Subject subject = Subject.getById(subject_id);
        subject.addStudent(this.id);

        int id = Database.Registries.get(Database.Registries.size() - 1).id + 1;
        Registry registry = new Registry(id, subject_id, this.id);
        Database.Registries.add(registry);
    }

    public void cancelRegistry(int subject_id) throws Exception {
        Subject subject = Subject.getById(subject_id);
        Registry registry = Registry.getBySubjectAndStudentIds(subject_id, this.id);

        subject.rmStudent(this.id);
        int index = Database.Registries.indexOf(registry);
        Database.Registries.remove(index);
    }

    public List<Subject> getSubjects(){
        return Database.Subjects;
    }

    public List<Subject> getRegisteredSubjects() {
        List<Integer> registeredSubjects = this.getRegistries().stream()
                .map(registry -> registry.subject_id).toList();

        if (registeredSubjects.size() == 0) {
            return List.of();
        }

        return Database.Subjects.stream().filter(subject -> {
            if (registeredSubjects.contains(subject.id)) {
                return true;
            }
            return false;
        }).toList();
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
        return this.getRegistries().size() <= 6;
    }

    public boolean validateOptionalRegistries() {
        return true;
    }

}

import java.util.*;

public class Teacher extends User {

    Teacher(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public static Teacher getById(int id) {
        return Database.Users.stream()
                .filter(user -> user.getClass() == Teacher.class && user.id == id)
                .map(user -> (Teacher) user)
                .toList().get(0);
    }

    public List<Subject> getSubjects() {
        return Database.Subjects.stream().filter(subject -> subject.teacher == this.id).toList();
    }

    public List<Student> getRegisteredStudents(int subject_id) {
        List<Registry> registries = Database.Registries.stream().filter(registry -> registry.subject_id == subject_id).toList();
        List<Integer> studentIds = registries.stream().map(registry -> registry.student_id).toList();
        List<Student> allStudents = (List<Student>) Database.Users.stream().filter(user -> user.getClass() == Student.class);
        return allStudents.stream().filter(student -> {
            if (studentIds.contains(student.id)) {
                return true;
            }
            return false;
        }).toList();
    }

}

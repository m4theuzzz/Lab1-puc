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

    public List<Subject> getGivenSubjects() {
        return Database.Subjects.stream().filter(subject -> subject.teacher == this.id).toList();
    }

    public List<Student> getRegisteredStudents(int subject_id) {
        Subject subject = Subject.getById(subject_id);
        return subject.getRegisteredStudents().stream().map(Student::getById).toList();
    }
}

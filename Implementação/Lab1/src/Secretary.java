import java.util.*;
public class Secretary extends User {
    Secretary(String email, String password) {
        super(email, password);
    }

    public Grade buildGrade() {
        return new Grade(
                1,
                List.of(new Classes(1, 2, 1, 1, true, 2.00)),
                List.of(new Classes(2, 2, 1, 1, true, 2.00)),
                1
        );

    }

    public List<Teacher> getTeachers() {
        return List.of(new Teacher("", ""));
    }

    public List<Student> getStudents() {
        return List.of(new Student("", "", 1));
    }

    public List<Classes> getClasses() {
        return List.of(new Classes(2, 2, 1, 1, true, 2.00));
    }

    public List<Registry> getRegistries() {
        return List.of(new Registry(1,1,1, new Date(), new Date()));
    }

    public Billing buildRegistryBill(int student_id) {
        return new Billing(1, 1.0, 1);
    }

    public Secretary getSecretary() {
        return this;

    }

}

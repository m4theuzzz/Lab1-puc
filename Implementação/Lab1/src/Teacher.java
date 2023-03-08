import java.util.*;

public class Teacher extends User {
    public final String subject;

    Teacher(String email, String password, String subject) {
        super(email, password);
        this.subject = subject;
    }

    public List<Student> getRegisteredStudents(int class_id){
        return List.of(new Student("", "", 1));
    }

    public Teacher getTeacher(){
        return this;
    }
}

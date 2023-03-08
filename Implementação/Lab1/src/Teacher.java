import java.util.*;

public class Teacher extends User {
    Teacher(String email, String password) {
        super(email, password);
    }

    public List<Student> getRegisteredStudents(int class_id){
        return List.of(new Student("", "", 1));
    }

    public Teacher getTeacher(){
        return this;
    }
}

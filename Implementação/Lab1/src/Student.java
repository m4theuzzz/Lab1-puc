import java.util.*;

public class Student extends User {
    private int period;

    Student(String email, String password, int period) {
        super(email, password);
        this.period = period;
    }

    public void makeRegistry(int registry_id) {
    }

    public void cancelRegistry(int registry_id) {
    }

    public Student getStudent() {
        return this;
    }

    public boolean validateMandatoryRegistries(int grade_id) {
        return true;
    }

    public boolean validateTotalRegistries(int grade_id) {
        return true;
    }

    public boolean validateOptionalRegistries(int grade_id) {
        return true;
    }

}

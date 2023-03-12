import java.util.*;

public class Grade {
    protected int id;
    protected List<Integer> mandatorySubjects;
    protected List<Integer> optionalSubjects;
    protected int period;

    Grade(int id, List<Integer> mandatorySubject, List<Integer> optionalSubject, int period) {
        this.id = id;
        this.mandatorySubjects = mandatorySubject;
        this.optionalSubjects = optionalSubject;
        this.period = period;
    }

    public static Grade getById(int id) {
        return Database.Grades.stream()
                .filter(grade -> grade.id == id)
                .toList().get(0);
    }

    public List<Subject> getMandatorySubjects() {
        return Database.Subjects.stream().filter(subject -> {
            if (this.mandatorySubjects.contains(subject.id)){
                return true;
            }
            return false;
        }).toList();
    }

    public List<Subject> getOptionalSubjects() {
        return Database.Subjects.stream().filter(subject -> {
            if (this.optionalSubjects.contains(subject.id)){
                return true;
            }
            return false;
        }).toList();
    }
}

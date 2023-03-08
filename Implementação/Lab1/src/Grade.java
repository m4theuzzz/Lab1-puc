import java.util.*;

public class Grade {
    private int id;
    private List<Classes> mandatoryClasses;
    private List<Classes> optionalClasses;
    private int period;

    Grade(int id, List<Classes> mandatoryClasses, List<Classes> optionalClasses, int period) {
        this.id = id;
        this.mandatoryClasses = mandatoryClasses;
        this.optionalClasses = optionalClasses;
        this.period = period;
    }

    public Grade getGrade() {
        return this;
    }
}

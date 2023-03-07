import java.util.Date;

public class Registry {
    private int id;
    private int class_id;
    private int student_id;
    private Date startDate;
    private Date endDate;

    Registry(int id, int class_id, int student_id, Date startDate, Date endDate) {
        this.id = id;
        this.class_id = class_id;
        this.student_id = student_id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Registry getRegistry() {
        return this;
    }
}

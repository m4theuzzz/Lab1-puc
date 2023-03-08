import java.util.*;
public class Billing {
    private int id;
    private double price;
    private int student_id;

    Billing(int id, double price, int student_id) {
        this.id = id;
        this.price = price;
        this.student_id = student_id;
    }

    public void sendBill() {
    }

    public Billing getBilling() {
        return this;
    }
}

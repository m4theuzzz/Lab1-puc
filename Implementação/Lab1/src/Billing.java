public class Billing {
    protected int id;
    protected double price;
    protected int student_id;

    Billing(int id, double price, int student_id) {
        this.id = id;
        this.price = price;
        this.student_id = student_id;
    }

    public static Billing getById(int id) {
        return Database.Billings.stream()
                .filter(billing -> billing.id == id)
                .toList().get(0);
    }

    public void sendBill() {
        Student student = Student.getById(this.student_id);
        System.out.println(student.id + " - " + student.name + " = R$" + this.price);
    }

}

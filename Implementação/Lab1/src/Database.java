import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    public static List<User> Users = new ArrayList<>();
    public static List<Grade> Grades = new ArrayList<>();
    public static List<Subject> Subjects = new ArrayList<>();
    public static List<Registry> Registries = new ArrayList<>();
    public static List<Billing> Billings = new ArrayList<>();

    public static void mockBaseData() {
        Secretary secretary = new Secretary(1, "Maicon", "maicon@puc.br", "123456");
        Database.Users.add(secretary);
        Database.Users.add(new Student(2, "Josefina", "josefina@puc.br", "123456", 1));
        Database.Users.add(new Teacher(3, "Cleiton", "cleiton@puc.br", "123456"));
        Database.Users.add(new Teacher(4, "Eveline", "eveline@puc.br", "123456"));

        Database.Subjects.add(new Subject(1, "Defense Against Dark Arts", List.of(2), 1, 60, true, 150.99, 4, new Date(), new Date("31/12/2025")));
        secretary.createSubject("Herbology", 1, 10, 1.50, 3, new Date(), new Date("2025/12/31"));
        secretary.createSubject("Incantations", 1, 15, 1.50, 4, new Date(), new Date("2025/12/31"));
        secretary.createSubject("Aritmancy", 1, 20, 1.50, 3, new Date(), new Date("2022/12/31"));
        secretary.createSubject("Potions", 1, 15, 1.50, 4, new Date(), new Date("2025/12/31"));
        secretary.createSubject("Hex", 1, 30, 1.50, 3, new Date(), new Date("2025/12/31"));

        Database.Grades.add(new Grade(
                1,
                Database.Subjects.subList(0,3).stream().map(subject -> subject.id).toList(),
                Database.Subjects.subList(4,5).stream().map(subject -> subject.id).toList(),
                1
        ));
        Database.Registries.add(new Registry(1, 1, 2));
        Database.Billings.add(new Billing(1, 0.0, 2));
    }
}

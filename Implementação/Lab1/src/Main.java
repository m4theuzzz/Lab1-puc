import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        List<User> users = new Mock().generateMockUsers();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        User toLog = new User(email, password);

        toLog.login(users);
    }
}

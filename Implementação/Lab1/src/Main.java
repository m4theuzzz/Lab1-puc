import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final User loggedUser = null;

    public static void globalMenu(String type) {
        int option;
        switch (type) {
            case "Student":
                System.out.println("Bem vindo(a), estudante. Escolha uma opção:");
                System.out.println("1 - Fazer novo registro");
                System.out.println("2 - Cancelar registro");
                System.out.println("3 - Listar registros");
                option = scanner.nextInt();
                studentMenu(option);

                break;
            case "Secretary":
                System.out.println("Bem vindo(a), secretário(a). Escolha uma opção:");
                System.out.println("1 - Listar professores");
                System.out.println("2 - Listas estudantes");
                System.out.println("3 - Listar matérias");
                System.out.println("4 - Listar matrículas");
                System.out.println("5 - Montar grade");
                option = scanner.nextInt();
                secretaryMenu(option);
                break;
            case "Teacher":
                System.out.println("Bem vindo(a), professor(a). Escolha uma opção:");
                System.out.println("1 - Listar estudantes matriculados em minha disciplina");
                option = scanner.nextInt();
                teacherMenu(option);

                break;

        }
    }

    public static void studentMenu(int option) {
        switch (option) {
            case 1:
                System.out.println("Novo registro de matrícula em matéria");
                // listar mateiras
                System.out.println("Escolha o ID da matéria");
                // registrar de fato
            case 2:
                System.out.println("Cancelar registro");
                // listar registros
                System.out.println("Escolha o ID do registro");
                // cancelar o registro
            case 3:
                // listar

        }
    }

    public static void secretaryMenu(int option) {
        switch (option) {
            case 1:
                System.out.println("Novo registro de matrícula em matéria");
                // listar mateiras
                System.out.println("Escolha o ID da matéria");

        }
    }

    public static void teacherMenu(int option) {
        switch (option) {
            case 1:
                System.out.println("Novo registro de matrícula em matéria");
                // listar mateiras
                System.out.println("Escolha o ID da matéria");

        }
    }

    public static void main(String[] args) {
        List<User> users = new Mock().generateMockUsers();

        System.out.println("BEM VINDO AO SISTEMA DE MATRÍCULAS - MATRICOOLY");
        System.out.println("");

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        User toLog = new User(email, password);

        toLog.login(users);
    }
}

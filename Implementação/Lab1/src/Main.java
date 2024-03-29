import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    static Scanner scanner = new Scanner(System.in);
    static Teacher loggedTeacher = null;
    static Secretary loggedSecretary = null;
    static Student loggedStudent = null;

    public static void logOut() {
        loggedStudent = null;
        loggedSecretary = null;
        loggedTeacher = null;

        main(new String[] {});
    }

    public static void globalMenu() throws IOException {
        int option = 1;
        while (option != 0) {
            if (loggedStudent != null) {
                System.out.println("Bem vindo(a), estudante. Escolha uma opção:");
                System.out.println("1 - Fazer novo registro");
                System.out.println("2 - Cancelar registro");
                System.out.println("3 - Listar registros");
                System.out.println("6 - Log Out");
                option = scanner.nextInt();
                studentMenu(option);
            } else if (loggedSecretary != null) {
                System.out.println("Bem vindo(a), secretário(a). Escolha uma opção:");
                System.out.println("1 - Listar professores");
                System.out.println("2 - Listas estudantes");
                System.out.println("3 - Listar matérias");
                System.out.println("4 - Listar matrículas");
                System.out.println("5 - Enviar cobrança para aluno");
                System.out.println("6 - Log Out");
                option = scanner.nextInt();
                scanner.nextLine();
                secretaryMenu(option);
            } else if (loggedTeacher != null) {
                System.out.println("Bem vindo(a), professor(a). Escolha uma opção:");
                System.out.println("1 - Listar estudantes matriculados em minha disciplina");
                System.out.println("6 - Log Out");
                option = scanner.nextInt();
                scanner.nextLine();
                teacherMenu(option);
            }
        }

        System.out.println("Obrigado e volte sempre! =)");
    }

    public static void studentMenu(int option) throws IOException {
        switch (option) {
            case 1:
                System.out.println("Novo registro de matrícula em matéria");
                List<Subject> subjects = loggedStudent.getSubjects();
                subjects.forEach(subject -> {
                    if (subject.isInRegistryPeriod()) {
                        System.out.println(
                                ANSI_GREEN + subject.id + " - " + subject.name + ANSI_RESET);
                    } else {
                        System.out.println(
                                ANSI_YELLOW + subject.id + " - " + subject.name + " (out of registry period)"
                                        + ANSI_RESET);
                    }
                });
                System.out.println("Escolha o ID da matéria");
                int subjectId = scanner.nextInt();
                scanner.nextLine();
                try {
                    loggedStudent.makeRegistry(subjectId);
                    System.out.println(ANSI_GREEN + "Registro feito com sucesso!" + ANSI_RESET);
                } catch (Exception err) {
                    System.out.println(ANSI_RED + err.getMessage() + ANSI_RESET);
                }

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();
                break;
            case 2:
                System.out.println("Cancelar matrícula");
                System.out.println("Escolha o ID da matéria");

                List<Subject> registeredSubjects = loggedStudent.getRegisteredSubjects();
                registeredSubjects.forEach(subject -> {
                    if (subject.isInRegistryPeriod()) {
                        System.out.println(
                                ANSI_GREEN + subject.id + " - " + subject.name + ANSI_RESET);
                    } else {
                        System.out.println(
                                ANSI_YELLOW + subject.id + " - " + subject.name + " (out of registry period)"
                                        + ANSI_RESET);
                    }
                });

                int registeredSubjectId = scanner.nextInt();
                scanner.nextLine();
                try {
                    loggedStudent.cancelRegistry(registeredSubjectId);
                    System.out.println(ANSI_GREEN + "Registro cancelado com sucesso." + ANSI_RESET);
                } catch (Exception err) {
                    System.out.println(ANSI_RED + err.getMessage() + ANSI_RESET);
                }

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();
                break;
            case 3:
                System.out.println("Minhas Matrículas:");
                List<Registry> registries = loggedStudent.getRegistries();

                registries.forEach(registry -> {
                    Subject subject = Subject.getById(registry.subject_id);
                    System.out.println(
                            ANSI_GREEN + "ID: " + subject.id + " | Nome: " + subject.name + ANSI_RESET
                    );
                });
                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();
                break;
            case 6:
                logOut();
                break;
        }
    }

    public static void secretaryMenu(int option) throws IOException {
        switch (option) {
            case 1:
                System.out.println("Lista de Professores");

                List<Teacher> teachers = loggedSecretary.getTeachers();
                teachers.forEach(teacher -> System.out.println(
                        ANSI_GREEN + teacher.name + " - " + teacher.email + ANSI_RESET));

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();

                break;
            case 2:
                System.out.println("Lista de Alunos");

                List<Student> students = loggedSecretary.getStudents();
                students.forEach(student -> System.out.println(
                        ANSI_GREEN + student.name + " - " + student.email + ANSI_RESET));

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();

                break;
            case 3:
                System.out.println("Lista de Matérias");

                List<Subject> subjects = loggedSecretary.getSubjects();
                subjects.forEach(subject -> {
                    if (subject.isInRegistryPeriod()) {
                        System.out.println(
                                ANSI_GREEN + subject.id + " - " + subject.name + ANSI_RESET);
                    } else {
                        System.out.println(
                                ANSI_YELLOW + subject.id + " - " + subject.name + " (out of registry period)"
                                        + ANSI_RESET);
                    }

                });

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();

                break;
            case 4:
                System.out.println("Lista de Matrículas");

                List<Registry> registries = loggedSecretary.getRegistries();
                registries.forEach(registry -> {
                    Student student = Student.getById(registry.student_id);
                    Subject subject = Subject.getById(registry.subject_id);
                    System.out.println(
                            ANSI_GREEN + student.name + " <-> " + subject.name + ANSI_RESET);
                });

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();

                break;
            case 5:
                System.out.println("Enviando cobranças");

                loggedSecretary.sendStudentsBill();

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();

                break;
            case 6:
                logOut();
                break;
        }
    }

    public static void teacherMenu(int option) throws IOException {
        switch (option) {
            case 1:
                System.out.println("Suas matérias lessionadas:");
                List<Subject> givenSubjects = loggedTeacher.getGivenSubjects();

                givenSubjects.forEach(subject ->
                    System.out.println(ANSI_GREEN + subject.id + " - " + subject.name + ANSI_RESET)
                );

                System.out.println("Selecione de qual das suas matérias você deseja listar os alunos:");
                int subjectId = scanner.nextInt();
                scanner.nextLine();

                List<Student> students = loggedTeacher.getRegisteredStudents(subjectId);
                students.forEach(subject ->
                        System.out.println(ANSI_GREEN + subject.id + " - " + subject.name + ANSI_RESET)
                );

                System.out.println("");
                System.out.println("Pressione Enter para Voltar");
                System.in.read();
                break;
            case 6:
                logOut();
                break;
        }
    }

    public static void main(String[] args) {
        Database.mockBaseData();

        System.out.println("BEM VINDO AO SISTEMA DE MATRÍCULAS - MATRICOOLY");
        System.out.println("");

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        try {
            User loggedUser = User.login(email, password);
            if (loggedUser.getClass() == Secretary.class) {
                loggedSecretary = (Secretary) loggedUser;
            } else if (loggedUser.getClass() == Teacher.class) {
                loggedTeacher = (Teacher) loggedUser;
            } else if (loggedUser.getClass() == Student.class) {
                loggedStudent = (Student) loggedUser;
            }

            globalMenu();
        } catch (Exception error) {
            System.out.println(ANSI_RED + error.getMessage() + ANSI_RESET);
            main(new String[] { "" });
        }
    }
}

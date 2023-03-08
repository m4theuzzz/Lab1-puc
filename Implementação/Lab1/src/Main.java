import java.util.*;

public class Main {

    public static List<User> generateMockUsers() {
        List<User> mockUsers = new ArrayList<User>();

        User mockSecretary1 = new Secretary("secretaria@pucmail.com", "123456");
        User mockSecretary2 = new Secretary("secretaria@pucmail.com", "123456");
        User mockStudent1 = new Student("estudante@pucmail.com", "123456", 1);
        User mockStudent2 = new Student("estudante@pucmail.com", "123456", 2);
        User mockTeacher1 = new Teacher("professor@pucmail.com", "123456");
        User mockTeacher2 = new Teacher("professor@pucmail.com", "123456");

        mockUsers.add(mockSecretary1);
        mockUsers.add(mockSecretary2);
        mockUsers.add(mockStudent1);
        mockUsers.add(mockStudent2);
        mockUsers.add(mockTeacher1);
        mockUsers.add(mockTeacher2);

        return mockUsers;

    }

    public static void main(String[] args) {
        List a = generateMockUsers();

        System.out.println(a.toString());
    }
}
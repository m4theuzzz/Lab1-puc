import java.util.*;

public class Main {

    public static void globalMenu(String type) {
        switch (type) {
            case "student":
                System.out.println("Bem vindo(a), estudante. Escolha uma opção:");
                System.out.println("1 - Fazer novo registro");
                System.out.println("2 - Cancelar registro");
                System.out.println("3 - Listar registros");
                break;
            case "secretary":
                System.out.println("Bem vindo(a), secretário(a). Escolha uma opção:");
                System.out.println("1 - Listar professores");
                System.out.println("2 - Listas estudantes");
                System.out.println("3 - Listar matérias");
                System.out.println("4 - Listar matrículas");
                System.out.println("5 - Montar grade");
                break;
            case "teacher":
                System.out.println("Bem vindo(a), professor(a). Escolha uma opção:");
                System.out.println("1 - Listar estudantes matriculados em minha disciplina");
                break;

        }
    }

    public static void studentMenu(int option) {
        switch (option) {
            case 1:

        }
    }

    public static void main(String[] args) {

        System.out.println("BEM VINDO AO SISTEMA DE MATRÍCULAS - MATRICOOLY");
        System.out.println("");

        System.out.println(a.toString());
    }
}
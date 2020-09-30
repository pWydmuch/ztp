package zad2;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        new Controller().start();

    }

    private void start(){
        System.out.println("Podaj definicje klasy");
        Scanner scanner = new Scanner(System.in);
        String classDescription = scanner.nextLine();
        CodeGenerator codeGenerator = new CodeGenerator();
        System.out.println("Wygenerować gettery i settery (T/N)?");
        String gettersSetters = scanner.nextLine();
        System.out.println("Wygenerować singleton (T/N)?");
        String singleton = scanner.nextLine();
        try {
            codeGenerator.generateCode(classDescription, gettersSetters, singleton);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

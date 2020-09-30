package zad2;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Car car = new Car.Builder("Fiat","Uno")
                    .setMaxPeople(5)
                    .setEngineCapacity(1.5)
                    .setRegistrationNumbet("DW 0911")
                    .build();
        int i = -1;
        while(i!=0){
            showOptions();
            i = scanner.nextInt();
            chooseOption(car,i);
        }
    }
    public static void showOptions(){
        System.out.println("[0] Zakończ");
        System.out.println("[1] Pokaż jak daleko od startu jestem");
        System.out.println("[2] Włącz silnik");
        System.out.println("[3] Wyłącz silnik");
        System.out.println("[4] Jedz do przodu");
        System.out.println("[5] Jedz do tylu");
        System.out.println("[6] Zatrzymaj się");
    }

    public static void chooseOption (Car car, int option){
        int meters;
        switch(option){
            case 0: return;
            case 1:
                System.out.println(car.getMetersFromStart());
                break;
            case 2:
                car.startEngine();
                break;
            case 3:
                car.stopEngine();
                break;
            case 4:
                System.out.println("Ile metrów chcesz przejechac");
                meters = scanner.nextInt();
                car.goForward(meters);
                break;
            case 5:
                System.out.println("Ile metrów chcesz przejechac");
                meters = scanner.nextInt();
                car.goBackward(meters);
                break;
            case 6:
                car.stopGoing();
                break;
            default:
                System.out.println("Nieprawidlowa opcja");
        }
    }
}

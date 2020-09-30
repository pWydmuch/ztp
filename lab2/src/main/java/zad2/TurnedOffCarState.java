package zad2;

public class TurnedOffCarState implements CarState {

    Car car;

    public TurnedOffCarState(Car car) {
        this.car = car;
    }

    @Override
    public void goForward(int meters) {
        System.out.println("Nie możesz jechać gdy samochód jest zgaszony");
    }

    @Override
    public void goBackward(int meters) {
        System.out.println("Nie możesz jechać gdy samochód jest zgaszony");
    }

    @Override
    public void stopGoing() {
        System.out.println("Samochód jest zgaszony i już stoi");
    }

    @Override
    public void startEngine() {
        System.out.println("Zapalam silnik");
        car.setCarState(new StoppedCarState(car));
    }

    @Override
    public void stopEngine() {
        System.out.println("Samochód jest już zgaszony zgaszony");
    }
}

package zad2;

public class GoingForwardCarState implements CarState {

    Car car;

    public GoingForwardCarState(Car car) {
        this.car = car;
    }

    @Override
    public void goForward(int meters) {
        System.out.println("Jede do przodu o "+meters+ " metrów");
        car.setMetersFromStart(car.getMetersFromStart()+meters);
    }

    @Override
    public void goBackward(int meters) {
        System.out.println("Jesziesz do przodu, żeby zmienić kierunek musisz najpierw się zaczymać");
    }

    @Override
    public void stopGoing() {
        System.out.println("Zaczymuje się");
        car.setCarState(new StoppedCarState(car));
    }

    @Override
    public void startEngine() {
        System.out.println("Silnik jest już włączony");
    }

    @Override
    public void stopEngine() {
        System.out.println("Nie możesz zgasić silnika w trakcie jazdy");
    }
}

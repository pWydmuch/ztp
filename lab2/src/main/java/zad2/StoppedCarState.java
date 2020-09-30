package zad2;

public class StoppedCarState implements CarState {
    Car car;

    public StoppedCarState(Car car) {
        this.car = car;
    }

    @Override
    public void goForward(int meters) {
        System.out.println("Jede do przodu o "+meters+ " metrów");
        car.setMetersFromStart(car.getMetersFromStart()+meters);
        car.setCarState(new GoingForwardCarState(car));
    }

    @Override
    public void goBackward(int meters) {
        System.out.println("Jede do tyłu o "+meters+ " metrów");
        car.setMetersFromStart(car.getMetersFromStart()-meters);
        car.setCarState(new GoingBackwardCarState(car));
    }

    @Override
    public void stopGoing() {
        System.out.println("Już stoimy");
    }

    @Override
    public void startEngine() {
        System.out.println("Silnik jest już włączony");
    }

    @Override
    public void stopEngine() {
        System.out.println("Wyłączam silnik");
        car.setCarState(new TurnedOffCarState(car));
    }
}

package zad2;

public interface CarState {
    void goForward(int meters);
    void goBackward(int meters);
    void stopGoing();
    void startEngine();
    void stopEngine();
}

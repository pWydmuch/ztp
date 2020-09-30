package ztp.zad2;

public class Car {

    private int maxPeaple;
    private String brand;
    public static int howMany = 0;

    public Car() {
        howMany++;
    }

    public void print(){
        System.out.println("Car");
    }

    public int getMaxPeaple() {
        return maxPeaple;
    }

    public void setMaxPeaple(int maxPeaple) {
        this.maxPeaple = maxPeaple;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static int getHowMany() {
        return howMany;
    }

    public static void setHowMany(int howMany) {
        Car.howMany = howMany;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxPeaple=" + maxPeaple +
                ", brand='" + brand + '\'' +
                '}';
    }
}

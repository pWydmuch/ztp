package zad2;

public class Car implements CarState {

    private CarState carState;
    private String brand;
    private String model;
    private int maxPeople;
    private double engineCapacity;
    private int ocNumber;
    private String registrationNumber;
    private int metersFromStart;

    private Car(Builder builder) {
        carState = new TurnedOffCarState(this);
        this.brand = builder.brand;
        this.model = builder.model;
        this.maxPeople = builder.maxPeople;
        this.engineCapacity = builder.engineCapacity;
        ocNumber = builder.ocNumber;
        this.registrationNumber = builder.registrationNumbet;
    }

    @Override
    public void goForward(int meters) {
        carState.goForward(meters);
    }

    @Override
    public void goBackward(int meters) {
        carState.goBackward(meters);
    }

    @Override
    public void stopGoing() {
        carState.stopGoing();
    }

    @Override
    public void startEngine() {
        carState.startEngine();
    }

    @Override
    public void stopEngine() {
        carState.stopEngine();
    }

    public static final class Builder{
        private String brand;
        private String model;
        private int maxPeople;
        private double engineCapacity;
        private int ocNumber;
        private String registrationNumbet;

        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMaxPeople(int maxPeople) {
            this.maxPeople = maxPeople;
            return this;
        }

        public Builder setEngineCapacity(double engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder setOcNumber(int ocNumber) {
            ocNumber = ocNumber;
            return this;
        }

        public Builder setRegistrationNumbet(String registrationNumbet) {
            this.registrationNumbet = registrationNumbet;
            return this;
        }

        public Car build(){
            return new Car(this);
        }

    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getMaxPeople() {
        return maxPeople;
    }
    public double getEngineCapacity() {
        return engineCapacity;
    }
    public int getOcNumber() {
        return ocNumber;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public int getMetersFromStart() {
        return metersFromStart;
    }

    public void setMetersFromStart(int metersFromStart) {
        this.metersFromStart = metersFromStart;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }
}

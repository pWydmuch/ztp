package ztp.zad1;

public  class Animal {
    int limbsNumber;

    public Animal(int limbsNumber) {
        this.limbsNumber = limbsNumber;
    }

    public int getLimbsNumber() {
        return limbsNumber;
    }

    public void setLimbsNumber(int limbsNumber) {
        this.limbsNumber = limbsNumber;
    }

    void printAnimal(){
        System.out.println("Animal{" +
                "limbsNumber=" + limbsNumber +
                '}');
    }

    @Override
    public String toString() {
        return "Animal{" +
                "limbsNumber=" + limbsNumber +
                '}';
    }
}

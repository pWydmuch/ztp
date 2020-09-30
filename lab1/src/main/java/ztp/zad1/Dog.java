package ztp.zad1;

public class Dog extends Mammal {

    String name;

    public Dog(int limbsNumber, String furColour, String name) {
        super(limbsNumber, furColour);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void printDog(){
        System.out.println("Dog{" +
                "name='" + name + '\'' +
                ", furColour='" + furColour + '\'' +
                ", limbsNumber=" + limbsNumber +
                '}');
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", furColour='" + furColour + '\'' +
                ", limbsNumber=" + limbsNumber +
                '}';
    }
}

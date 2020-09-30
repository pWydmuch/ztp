package ztp.zad1;

public class Mammal extends Animal {

    String furColour;

    public Mammal(int limbsNumber, String furColour) {
        super(limbsNumber);
        this.furColour = furColour;
    }

    public String getFurColour() {
        return furColour;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }

    void printMammal(){
        System.out.println("Mammal{" +
                "furColour='" + furColour + '\'' +
                ", limbsNumber=" + limbsNumber +
                '}');
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "furColour='" + furColour + '\'' +
                ", limbsNumber=" + limbsNumber +
                '}';
    }
}

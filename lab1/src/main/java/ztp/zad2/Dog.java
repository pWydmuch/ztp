package ztp.zad2;

public class Dog {

    private int weight;
    private String name;
    public static int howMany =0;

    public Dog() {
        howMany++;
    }

    public void print(){
        System.out.println("Dog");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

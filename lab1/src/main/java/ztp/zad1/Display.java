package ztp.zad1;

public class Display {


    void showDataAnimal(Container<? extends Animal> animals){
        System.out.println("Animals list");
        animals.show(Animal::printAnimal);
    }
    void showDataMammal(Container<? extends Mammal> mammals){
        System.out.println("Mammals list");
        mammals.show(Mammal::printMammal);
    }
    void showDataDogs(Container<Dog> dogs){
        System.out.println("Dogs list");
        dogs.show(Dog::printDog);
    }

    void displayInfo(Animal animal){
        System.out.println("I am an animal");
        System.out.println(animal);
    }
    void displayInfo(Mammal mammal){
        System.out.println("I am a mammal");
        System.out.println(mammal);
    }
    void displayInfo(Dog dog){
        System.out.println("I am a dog");
        System.out.println(dog);
    }


    public static void main(String[] args) {
        Container<Animal> animals = new Container<>();
        Container<Mammal> mammals = new Container<>();
        Container<Dog> dogs = new Container<>();
        Animal animal = new Animal(4);
        Mammal mammal = new Mammal(4,"gray");
        Dog dog = new Dog(3,"gray","Azor");
        animals.add(animal);
        mammals.add(mammal);
        dogs.add(dog);
        Display display = new Display();
        display.showDataAnimal(animals);
        display.showDataAnimal(dogs);
        display.showDataMammal(mammals);
//        display.showDataDogs(animals);
        int i = 32;
        int.class.getClasses();

        display.displayInfo(animal);
        display.displayInfo(mammal);
        display.displayInfo(dog);
    }

    public static void maian(String[] args) {

    }
}

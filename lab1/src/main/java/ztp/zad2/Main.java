package ztp.zad2;

import java.lang.reflect.*;

public class Main {

    private static <T> T createGenericObject(Class<T> classT) {
        T newT = null;
        try {
            newT = classT.newInstance();
//            Method method = classT.getMethod("print", null);
//            System.out.println("Wywołanie metody dla klasy " + classT.getSimpleName());
//            method.invoke(newT, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newT;
    }

    private static <T> void createGenericArray(Class<T> classT, int length) {
        T[] tArray = (T[]) Array.newInstance(classT, length);
        try {
            for (int i = 0; i < tArray.length; i++) {
                tArray[i] = classT.newInstance();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        System.out.println("Testowanie tworzenia obiektu generycznego \n");
//        testCreatingNewInstance();
//        System.out.println("\nTestowanie tworzenia tablicy obiektów genetycznych \n");
//        testCreatingGenericArray();
        System.out.println("\nTestowanie kopiowania");
        testPair();


    }


    private static void testCreatingNewInstance(){
        System.out.println("Dla klasy Dog");
        System.out.println("liczba obiektów przed wywołaniem metody: " + Dog.howMany);
        createGenericObject(Dog.class);
        System.out.println("liczba obiektów po wywołaniu metody: " + Dog.howMany);
        System.out.println();
        System.out.println("Dla klasy Car");
        System.out.println("liczba obiektów przed wywołaniem metody: " + Car.howMany);
        createGenericObject(Car.class);
        System.out.println("liczba obiektów po wywołaniu metody: " + Car.howMany);

    }

    private static void testCreatingGenericArray(){
        System.out.println("Dla klasy Dog");
        System.out.println("liczba obiektów przed wywołaniem metody: " + Dog.howMany);
        createGenericArray(Dog.class,3);
        System.out.println("liczba obiektów po wywołaniu metody: " + Dog.howMany);
        System.out.println();
        System.out.println("Dla klasy Car");
        System.out.println("liczba obiektów przed wywołaniem metody: " + Car.howMany);
        createGenericArray(Car.class,4);
        System.out.println("liczba obiektów po wywołaniu metody: " + Car.howMany);
    }

    private static void testPair() {
        System.out.println("Dla klasy Dog");

        Dog dog1 = new Dog();
        dog1.setWeight(12);
        dog1.setName("Rufus");

        Dog dog2 = new Dog();
        dog2.setWeight(15);
        dog2.setName("Azor");

        Pair<Dog> pairDog = new Pair<>(dog1, dog2);
        Pair<Dog> pairDog2 = new Pair<>(new Dog(), new Dog());

        System.out.println();
        System.out.println("Przed klonowaniem");
        System.out.println(pairDog);
        System.out.println(pairDog2);
        pairDog2.clone(pairDog);
        System.out.println();
        System.out.println("Po klonowaniu");
        System.out.println(pairDog);
        System.out.println(pairDog2);
        System.out.println();

        System.out.println("Dla klasy Car");

        Car car1 = new Car();
        car1.setBrand("Audi");
        car1.setMaxPeaple(5);

        Car car2 = new Car();
        car2.setBrand("BMW");
        car2.setMaxPeaple(3);

        Pair<Car> pairCar = new Pair<>(car1, car2);
        Pair<Car> pairCar2 = new Pair<>(new Car(), new Car());
        System.out.println("Przed klonowaniem");
        System.out.println(pairCar);
        System.out.println(pairCar2);
        pairCar2.clone(pairCar);
        System.out.println();
        System.out.println("Po klonowaniu");
        System.out.println(pairCar);
        System.out.println(pairCar2);
    }
}

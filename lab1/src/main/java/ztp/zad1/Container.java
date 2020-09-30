package ztp.zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Container<T extends Animal>  {


    private List<T> list;

    public Container() {
        this.list = new ArrayList<T>();

    }

     void add(T t){
        Class<T> clazz = (Class<T>) t.getClass();
        try {
            T w = clazz.newInstance();
            System.out.println(w);
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.add(t);
    }

    void show( Consumer<T> consumer){
        list.forEach(consumer);
    }

}

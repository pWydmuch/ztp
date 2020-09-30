package ztp.zad2;

import java.lang.reflect.Field;

public class Pair <T> implements Cloneable {
    private T t1;
    private T t2;

    public Pair(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }



    public <T> void clone(Pair<T> otherPair) {
        T otherT1 = otherPair.t1;
        T otherT2 = otherPair.t2;

        Field[] fields = otherT1.getClass().getDeclaredFields();
        Field[] fields2 = otherT2.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields2[i].setAccessible(true);
            try {
                Field f = otherT1.getClass().getDeclaredField(fields[i].getName());
                f.setAccessible(true);
                f.set(t1, fields[i].get(otherT1));
                Field f2 = otherT2.getClass().getDeclaredField(fields2[i].getName());
                f2.setAccessible(true);
                f2.set(t2, fields2[i].get(otherT2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public T getT2() {
        return t2;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }
}

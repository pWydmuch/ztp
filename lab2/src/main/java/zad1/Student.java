package zad1;

import java.io.Serializable;

public class Student implements Cloneable, Serializable {

    private static int nr =1100;
    private int index;
    private String firstName;
    private String lastName;

    public Student() {
        index=nr;
        nr++;
    }

    public Student(int index, String firstName, String lastName) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(Student otherStudent){
        this(otherStudent.index,otherStudent.firstName,otherStudent.lastName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                '}';
    }
}

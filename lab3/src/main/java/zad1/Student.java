package zad1;

import java.io.Serializable;
import java.util.List;

public class Student implements Cloneable, Serializable {

    private static int nr =1100;
    private int index;
    private String firstName;
    private int age;
    private char gender;
    private String lastName;
    private List<Course> courseList;
    private Faculty faculty;

    public Student() {
        index=nr;
        nr++;
    }

    public Student(int index, String firstName, String lastName) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(int index, String firstName, String lastName,int age, char gender) {
        this.index = index;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.lastName = lastName;
    }

    public Student(Student otherStudent){
        this(otherStudent.index,otherStudent.firstName,otherStudent.lastName);
    }



    public Faculty getFaculty() {
        return faculty;
    }



    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
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

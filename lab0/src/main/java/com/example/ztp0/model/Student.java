package com.example.ztp0.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name ="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long indeks;
    String name;
    String surname;

    public Student() {
    }

    public Student(Long indeks) {
        this.indeks = indeks;
    }

    public Student(Long indeks, String name, String surname) {
        this.indeks = indeks;
        this.name = name;
        this.surname = surname;
    }

    public Long getIndeks() {
        return indeks;
    }

    public void setIndeks(Long indeks) {
        this.indeks = indeks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "indeks=" + indeks +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(indeks, student.indeks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indeks);
    }
}

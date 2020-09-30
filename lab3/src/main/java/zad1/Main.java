package zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static List<Course> courses;
    static List<Student> students;
    static  List<Faculty> faculties;

    public static void generateData(){
        Course algebra = new Course("Algebra",5);
        Course analiza = new Course("Analiza", 8);
        Course programowanie = new Course("Programowanie", 3);
        Course fizyka = new Course("Fizyka",2);
        Course pracInz = new Course("Praca inżynierska", 16);

        courses = new ArrayList<>(Arrays.asList(algebra,analiza,programowanie,fizyka,pracInz));

        Student jan = new Student(11111,"Jan","Nowak",21,'M');
        Student adam = new Student(22222,"Adam","Kowal",23,'M');
        Student monika = new Student(33333,"Monika","Warga",19,'K');
        Student jacek = new Student(44444,"Jacek","Lach",24,'M');
        Student ola = new Student(55555,"Ola","Nowak",20,'K');
        Student ala = new Student(66666,"Ala","Babicz",23,'K');
        Student bartosz = new Student(77777,"Bartosz","Marczak",21,'M');
        Student janusz = new Student(88888,"Janusz","Kowal",24,'M');

        students = new ArrayList<>(Arrays.asList(jan,adam,monika,jacek,ola,ala,bartosz,janusz));

        jan.setCourseList(new ArrayList<>(Arrays.asList(algebra,analiza)));
        adam.setCourseList(new ArrayList<>(Arrays.asList(algebra,fizyka)));
        monika.setCourseList(new ArrayList<>(Arrays.asList(algebra,analiza,pracInz)));
        jacek.setCourseList(new ArrayList<>(Arrays.asList(algebra,analiza,programowanie)));
        ola.setCourseList(new ArrayList<>(Arrays.asList(pracInz,analiza)));
        ala.setCourseList(new ArrayList<>(Arrays.asList(analiza,fizyka)));
        bartosz.setCourseList(new ArrayList<>(Arrays.asList(pracInz,analiza,algebra,fizyka)));
        janusz.setCourseList(new ArrayList<>(Arrays.asList(algebra,pracInz,fizyka)));

        Faculty weka = new Faculty("W-4");
        Faculty wiz = new Faculty("w-8");
        Faculty wppt = new Faculty("W-11");

        faculties = new ArrayList<>(Arrays.asList(weka,wiz,wppt));

        jan.setFaculty(weka);
        adam.setFaculty(weka);
        monika.setFaculty(wiz);
        jacek.setFaculty(wiz);
        ola.setFaculty(wiz);
        ala.setFaculty(wppt);
        bartosz.setFaculty(wppt);
        janusz.setFaculty(wppt);

        weka.setStudents(new ArrayList<>(Arrays.asList(jan,adam)));
        wiz.setStudents(new ArrayList<>(Arrays.asList(monika,jacek,ola)));
        wppt.setStudents(new ArrayList<>(Arrays.asList(ala,bartosz,janusz)));
    }


    public static void main(String[] args) throws CloneNotSupportedException {


        generateData();
        System.out.println("Filtrowanie");
        courses.stream().filter(course -> course.getEcts()>3).forEach(System.out::println);

        System.out.println("\nmap");
        students.stream().map(student -> student.getFaculty().getName()).forEach(System.out::println);

        System.out.println("\nmin/max");
        int minCourses = students.stream().map(s->s.getCourseList().size()).mapToInt(i->i).min().getAsInt();
        students.stream().filter(student -> student.getCourseList().size()==minCourses).forEach(System.out::println);

        students.stream().min(Comparator.comparingInt(s -> s.getCourseList().size())).ifPresent(System.out::println);

        System.out.println("\ngroupingBy");

        students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingDouble(Student::getAge)))
                .entrySet()
                .forEach(System.out::println);

    }


}

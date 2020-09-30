package zad1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Faculty implements Cloneable, Serializable {

    private static int nr = 1;
    private String name;
    private List<Student> students;

    public Faculty() {
        name = "W"+nr;
        nr++;
        students = new ArrayList<>();
    }

    public Faculty(Faculty otherFaculty) {
        name=otherFaculty.name;
        students=otherFaculty.students.stream()
                .map(Student::new)
                .collect(Collectors.toList());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Faculty faculty = (Faculty) super.clone();
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            Student clonedStudent = (Student) student.clone();
            list.add(clonedStudent);
        }
        faculty.setStudents(list);
        return faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

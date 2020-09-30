package zad1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University implements Cloneable, Serializable {

    private static int nr =1;
    private String name;
    private List<Faculty> faculties;

    public University(University otherUniversity){
        name=otherUniversity.name;
        faculties=otherUniversity.faculties
                .stream()
                .map(Faculty::new)
                .collect(Collectors.toList());
    }

    public University() {
        name="Politechnika nr " + nr ;
        faculties = new ArrayList<>();
        nr++;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        University university = (University) super.clone();
        List<Faculty> list = new ArrayList<>();
        for (Faculty faculty : faculties) {
            Faculty clonedFaculty = (Faculty) faculty.clone();
            list.add(clonedFaculty);
        }
        university.setFaculties(list);
        return university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}

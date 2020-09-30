package zad1;

import org.apache.commons.lang3.SerializationUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<University> generateStructure(int universitiesNr, int facultiesNr, int studentsNr){

        List<University> universities = Stream.generate(University::new)
                .limit(universitiesNr)
                .collect(Collectors.toList());
        for (University university : universities) {
            List<Faculty> faculties = Stream.generate(Faculty::new)
                    .limit(facultiesNr)
                    .collect(Collectors.toList());
            for (Faculty faculty : faculties) {
                List<Student> students = Stream.generate(Student::new)
                        .limit(studentsNr)
                        .collect(Collectors.toList());
                faculty.setStudents(students);
            }
            university.setFaculties(faculties);
        }
        return universities;
    }

    public static University copyByConstructor(University univeristy){
        University copiedUniversity = new University(univeristy);
        fillUniversityWithDummyData(copiedUniversity);
        return copiedUniversity;

    }
    public static University copyByCloneMethod(University univeristy) throws CloneNotSupportedException {
        University copiedUniversity = (University) univeristy.clone();
        fillUniversityWithDummyData(copiedUniversity);
        return copiedUniversity;
    }

    public static University copyByExternalLibrary(University univeristy){
        University copiedUniversity = SerializationUtils.clone(univeristy);
        fillUniversityWithDummyData(copiedUniversity);
        return copiedUniversity;
    }

    public static void fillUniversityWithDummyData(University university){
        university.setName("Copy univeristy");
        university.getFaculties().forEach(f->f.setName("copied faculty"));
        university.getFaculties()
                .forEach(f->f.getStudents()
                        .forEach(s->s.setIndex(0)));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<University> universities = generateStructure(1,5,5);
        University university = universities.get(0);
      University copiedByConstructor = copyByConstructor(university);
//        University copiedByConstructor = copyByCloneMethod(university);
//        University copiedByConstructor = copyByExternalLibrary(university);

        System.out.println(university);
        System.out.println(copiedByConstructor);

    }
}

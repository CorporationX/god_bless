package faang.school.godbless.counting_absences;

import java.util.*;

public class Main {

    Map<Tuple<String, Integer>, List<Student>> university = new HashMap<>();

    public void setUniversity(Map<Tuple<String, Integer>, List<Student>> map) {
        Objects.requireNonNull(map);
        this.university = map;
    }

    public static Map<Tuple<String, Integer>, List<Student>> generate(List<Student> students) {
        Objects.requireNonNull(students);
        Map<Tuple<String, Integer>, List<Student>> mapOfStudents = new HashMap<>();
        for (Student student : students) {
            mapOfStudents.computeIfAbsent(new Tuple<String, Integer>(student.faculty, student.year), k -> new ArrayList<>()).add(student);
        }
        return mapOfStudents;
    }

    public void enrollStudent(Student student) {
        Objects.requireNonNull(student);
        university.computeIfAbsent(new Tuple<String, Integer>(student.faculty, student.year), k -> new ArrayList<>()).add(student);
    }

    public void expelStudent(Student student) {
        Objects.requireNonNull(student);
        university.computeIfPresent(new Tuple<String, Integer>(student.faculty, student.year), (k, v) -> {
            v.remove(student);
            return v.isEmpty() ? null : v;
        });
    }

    public void getFacultyAndYear(String faculty, int year) {
//        is there a cleaner way to do this for multiple objects?
        Objects.requireNonNull(faculty);
        List<Student> students = university.get(new Tuple<String, Integer>(faculty, year));
        System.out.println("Faculty: " + faculty + " Year: " + year);
        for (Student student : students) {
            System.out.println("    " + student);
        }
    }

    public void printAll() {
        for (Map.Entry<Tuple<String, Integer>, List<Student>> entry : university.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().faculty() + " Year: " + entry.getKey().year());
            for (Student student : entry.getValue()) {
                System.out.println("    " + student);
            }
        }
    }
}

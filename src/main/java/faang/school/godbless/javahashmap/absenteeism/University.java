package faang.school.godbless.javahashmap.absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class University {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year);
    }

    public List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        HashMap<Pair<String, Integer>, List<Student>> groupedStudents = getAllStudentsByFacultyAndYear(students);
        return groupedStudents.get(new Pair<>(faculty, year));
    }

    public void printAllStudentsGroupedByFacultyAndYear() {
        HashMap<Pair<String, Integer>, List<Student>> groupedStudents = getAllStudentsByFacultyAndYear(students);
        groupedStudents.forEach((key, value) -> {
            System.out.println("Faculty: " + key.getFirst() + ", Year: " + key.getSecond());
            value.forEach(student -> System.out.println("   " + student));
        });
    }

    public HashMap<Pair<String, Integer>, List<Student>> getAllStudentsByFacultyAndYear(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                student -> new Pair<>(student.getFaculty(), student.getYear()),
                student -> {
                    List<Student> list = new ArrayList<>();
                    list.add(student);
                    return list;
                },
                (studentsOld, studentsNew) -> {
                    studentsOld.addAll(studentsNew);
                    return studentsOld;
                },
                HashMap::new
        ));
    }

    public List<Student> getStudents() {
        List<Student> studentsToReturn = new ArrayList<>();
        students.forEach(student -> studentsToReturn.add(
                new Student(student.getName(), student.getFaculty(), student.getYear())));
        return studentsToReturn;
    }
}

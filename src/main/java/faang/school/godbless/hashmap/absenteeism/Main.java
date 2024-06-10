package faang.school.godbless.hashmap.absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
    List<Student> studentsList = new ArrayList<>(List.of(
            new Student("John Doe", "Computer Science", 3),
            new Student("Jane Smith", "Mechanical Engineering", 2),
            new Student("Alice Johnson", "Business Administration", 4),
            new Student("Michael Brown", "Computer Science", 3)
    ));

    public Map<FacultyYear, List<Student>> getStudentsByFacultyYear(List<Student> students) {
        return students.stream()
                .collect(groupingBy(
                        student -> new FacultyYear(student.faculty(), student.year()),
                        HashMap::new,
                        toList())
                );
    }

    public boolean addStudent(Student student) {
        return studentsList.add(student);
    }

    public boolean deleteStudent(String studentName, String studentFaculty, Integer year) {
        return studentsList.removeIf(s -> s.name().equals(studentName)
                && s.faculty().equals(studentFaculty)
                && s.year().equals(year));
    }

    public List<Student> findAllStudentByFacultyYear(FacultyYear facultyYear) {
        return ofNullable(getStudentsByFacultyYear(studentsList).get(facultyYear))
                .orElseThrow(() -> new NoSuchElementException("No such students with FacultyYear: " + facultyYear));
    }

    public void printAllStudentsByFacultyYear() {
        getStudentsByFacultyYear(studentsList)
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

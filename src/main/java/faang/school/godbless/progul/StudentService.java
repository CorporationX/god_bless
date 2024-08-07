package faang.school.godbless.progul;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StudentService {

    public void addStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public void removeStudent(List<Student> students, String name, String faculty, int year) {
        var student = getStudentByNameFacultyYear(students, name, faculty, year);

        students.remove(student);

        if (student == null) {
            System.out.println("Student not found" + "\n");
        }
    }

    public void showGroupedStudents(List<Student> students) {
        var studentGroup = groupByFacultyAndYear(students);

        studentGroup.forEach((key, value) -> {
            System.out.println(key);
            value.stream()
                    .map(Student::getName)
                    .forEach(name -> System.out.println(" " + name));
        });
    }

    public void findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        var studentList = students.stream()
                .filter(student -> student.getFaculty().equals(faculty) &&
                        student.getYear() == year)
                .toList();

        System.out.println("Year " + year + " of " + faculty + " has " + studentList.size() + " student.");
        studentList.forEach(student -> System.out.println(student.getName()));
    }

    private Map<String, List<Student>> groupByFacultyAndYear(List<Student> students) {
        return students.stream().collect(groupingBy(student ->
                student.getFaculty() + " " + student.getYear() + " year:")
        );
    }

    private Student getStudentByNameFacultyYear(List<Student> students, String name, String faculty, int year) {
        return students.stream()
                .filter(student -> student.getName().equals(name) &&
                        student.getFaculty().equals(faculty) &&
                        student.getYear() == year)
                .findFirst()
                .orElse(null);
    }
}

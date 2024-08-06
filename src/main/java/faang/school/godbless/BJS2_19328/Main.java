package faang.school.godbless.BJS2_19328;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.*;

@Getter
public class Main {

    private final List<Student> students = new ArrayList<>();

    {
        students.add(new Student("Ivan", "Math", 1));
        students.add(new Student("Stepan", "Rus", 1));
        students.add(new Student("Nikolay", "Math", 2));
        students.add(new Student("Irina", "Biology", 3));
        students.add(new Student("Olga", "Chemistry", 2));
        students.add(new Student("Aleksandr", "Rus", 1));
        students.add(new Student("Igor", "Chemistry", 3));
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String name, String faculty, Integer year) {
        students.removeIf(student -> Objects.equals(student.getName(), name)
                && Objects.equals(student.getFaculty(), faculty)
                && Objects.equals(student.getYear(), year));
    }

    public List<Student> findStudentsByFacultyAndYear(String faculty, Integer year) {
        return students.stream()
                .filter(s -> Objects.equals(s.getFaculty(), faculty) && Objects.equals(s.getYear(), year))
                .toList();
    }


    public Map<Group, List<Student>> getStudentsGroupedByFacultyAndYear(List<Student> students) {
        Map<Group, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            Group group = new Group(student.getFaculty(), student.getYear());
            if (result.containsKey(group)) {
                result.get(group).add(student);
            } else {
                result.put(group, new ArrayList<>(List.of(student)));
            }
        }
        return result;
    }


    @AllArgsConstructor
    @Data
    static class Group {
        private String faculty;
        private Integer year;
    }
}

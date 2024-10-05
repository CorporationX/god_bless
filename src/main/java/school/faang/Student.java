package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private String faculty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, faculty);
    }

    public static HashMap<Student, List<Student>> groupedStudents(List<Student> list){
        HashMap<Student, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : list) {
            groupedStudents.computeIfAbsent(student, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }
}

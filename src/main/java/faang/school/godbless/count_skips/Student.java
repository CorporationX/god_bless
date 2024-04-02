package faang.school.godbless.count_skips;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    public static Map<Map.Entry<String, Integer>, List<Student>> groupStudents(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>(student.faculty, student.year);
            if (!map.containsKey(entry)) {
                map.put(entry, new ArrayList<>());
            }
            map.get(entry).add(student);
        }
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }
}

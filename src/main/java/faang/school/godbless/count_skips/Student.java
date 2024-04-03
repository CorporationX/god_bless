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

    public static Map<Pair, List<Student>> groupStudents(List<Student> students) {
        Map<Pair, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.faculty, student.year);
            if (!map.containsKey(pair)) {
                map.put(pair, new ArrayList<>());
            }
            map.get(pair).add(student);
        }
        return map;
    }

}

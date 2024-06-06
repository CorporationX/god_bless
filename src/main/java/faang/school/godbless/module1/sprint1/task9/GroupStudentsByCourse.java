package faang.school.godbless.module1.sprint1.task9;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class GroupStudentsByCourse {
    private final Map<Map.Entry<String, Integer>, List<Student>> map;

    public GroupStudentsByCourse(List<Student> students) {
        map = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> entry = Map.entry(student.getFaculty(), student.getYear());
            map.computeIfAbsent(entry, k -> new ArrayList<>()).add(student);
        }
    }
}

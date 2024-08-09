package faang.school.godbless.countAbsences;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Faculty {
    private String name;

    public static Map<PairKey<Faculty,Integer>, List<Student>> MapOfStudentsByFacultiesAndYears(List<Student> students) {
        Map<PairKey<Faculty,Integer>, List<Student>> resultMap = new HashMap<>();

        for (Student student : students) {
            PairKey<Faculty,Integer> facultyAndYearKey = new PairKey<>(student.getFaculty(), student.getYear());
            resultMap.computeIfAbsent(facultyAndYearKey, k -> new ArrayList<>()).add(student);
        }

        return resultMap;
    }
}

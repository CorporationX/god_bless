package faang.school.godbless.countAbsences;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Faculty {
    private String name;

    public static Map<PairFacultyYearKey, List<Student>> MapOfStudentsByFacultiesAndYears(List<Student> students) {
        Map<PairFacultyYearKey, List<Student>> resultMap = new HashMap<>();

        for (Student student : students) {
            PairFacultyYearKey facultyAndYearKey = new PairFacultyYearKey(student.getFaculty().getName(), student.getYear());
            resultMap.computeIfAbsent(facultyAndYearKey, k -> new ArrayList<>()).add(student);
        }

        return resultMap;
    }
}

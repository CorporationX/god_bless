package school.faang.students;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private Integer year;

    public static Map<FacultyYearKey, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<FacultyYearKey, List<Student>> groupStudents = new HashMap<>();

        students.forEach(student ->
                groupStudents
                        .computeIfAbsent(new FacultyYearKey(student.getFaculty(), student.getYear()),
                                facultyYearKey -> new ArrayList<>())
                        .add(student)
        );

        return groupStudents;
    }
}

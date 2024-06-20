package faang.school.godbless.java_sql.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentGrouper {

    static HashMap<FacultyYearPair, ArrayList<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        HashMap<FacultyYearPair, ArrayList<Student>> studentsMap = new HashMap<>();
        students.forEach(student -> {
            var facultyYearPair = new FacultyYearPair(student.faculty(), student.year());
            studentsMap.computeIfAbsent(facultyYearPair, key -> new ArrayList<>()).add(student);
        });
        return studentsMap;
    }
}

package school.faang.cachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    // First HashMap: Student -> Map of Subjects and Grades
    private Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();

    // Second HashMap: Subject -> List of Students
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

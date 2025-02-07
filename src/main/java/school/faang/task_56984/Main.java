package school.faang.task_56984;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Map<Subject, Integer> alexeyMap = addAlexeyMap();
        studentDatabase.addStudentWithGrades(new Student("Alexey"), alexeyMap);
        studentDatabase.printAllSubjectsWithStudents();
    }

    public static Map<Subject, Integer> addAlexeyMap() {
        Map<Subject, Integer> map = new HashMap<>();
        map.put(new Subject("Math"), 3);
        map.put(new Subject("Russian"), 4);
        map.put(new Subject("English"), 5);
        map.put(new Subject("History"), 3);
        return map;
    }
}
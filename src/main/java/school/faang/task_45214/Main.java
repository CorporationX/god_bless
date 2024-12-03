package school.faang.task_45214;

import school.faang.task_45214.model.Student;
import school.faang.task_45214.model.Subject;
import school.faang.task_45214.util.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Student, Map<Subject, Integer>> students = new HashMap<>();
        HashMap<Subject, List<Student>> subjects = new HashMap<>();

        StudentDatabase database = new StudentDatabase(students, subjects);
    }
}

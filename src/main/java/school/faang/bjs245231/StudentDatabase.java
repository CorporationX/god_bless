package school.faang.bjs245231;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private static HashMap<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static HashMap<Subject, List<Student>> subjectStudents = new HashMap<>();

//    private static HashMap<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
//    Добавление нового студента и его предметов с оценками.
//
//    Добавление нового предмета для существующего студента с оценкой.
//
//    Удаление студента и его предметов.
//
//    Вывод списка всех студентов и их оценок по предметам.

    public void addStudentWithMark(Student student, Map<Subject, Integer> grades) {
        Map<Subject, Integer> subjectIntegerMap = studentGrades.get(student);
        if (subjectIntegerMap != null) {
            subjectIntegerMap.
        } else {
            studentGrades.put(student, grades);
        }
    }

//     studentGrades.put(student, grades);
//        for (Subject subject : grades.keySet()) {
//        subjectStudents.putIfAbsent(subject, new ArrayList<>());
//        subjectStudents.get(subject).add(student);
//    }

}

package faang.school.godbless.cache.services;

import faang.school.godbless.cache.models.Student;
import faang.school.godbless.cache.models.Subject;

import java.util.HashMap;
import java.util.Map;

public class StudentService {

    public static void addNewStudentInStudentRatesWithAllSubjects(Student student,
                                                                  Map<Subject, Integer> subjects,
                                                                  Map<Student, Map<Subject, Integer>> studentsRates) {
        studentsRates.putIfAbsent(student, subjects);
    }

    public static void addNewSubjectForStudent(Student student,
                                               Subject subject,
                                               int rate,
                                               Map<Student, Map<Subject, Integer>> studentsRates) {
        Map<Subject, Integer> currentStudentMap = new HashMap<>();

        if (studentsRates.containsKey(student)) {
            currentStudentMap = studentsRates.get(student);
        }

        currentStudentMap.put(subject, rate);

        if (!studentsRates.containsKey(student)) {
            studentsRates.put(student, currentStudentMap);
        }
    }

    public static void removeStudentFromStudentsRates(Student student,
                                                      Map<Student, Map<Subject, Integer>> studentsRates) {
        studentsRates.remove(student);
    }

    public static void printStudentsAndRatesBySubject(Map<Student, Map<Subject, Integer>> studentsRates) {
        studentsRates.forEach((student, subjectIntegerMap) -> {
            if (subjectIntegerMap != null) {
                System.out.println(student + " attends next subjects and has next rates ");
                subjectIntegerMap.forEach((subject, integer) -> System.out.println("   " + subject + " - rate " + integer));
            }
        });
    }
}

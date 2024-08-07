package faang.school.godbless.cache.services;

import faang.school.godbless.cache.models.Student;
import faang.school.godbless.cache.models.Subject;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.cache.Main.studentsRates;

public class StudentService {

    public static void addNewStudentInStudentRatesWithAllSubjects(Student student, HashMap<Subject, Integer> subjects) {
        studentsRates.putIfAbsent(student, subjects);
    }

    public static void addNewSubjectForStudent(Student student, Subject subject, int rate) {
        Map<Subject, Integer> currentStudentMap = new HashMap<>();

        if (studentsRates.containsKey(student)) {
            currentStudentMap = studentsRates.get(student);
        }

        currentStudentMap.put(subject, rate);

        if (!studentsRates.containsKey(student)) {
            studentsRates.put(student, currentStudentMap);
        }
    }

    public static void removeStudentFromStudentsRates(Student student) {
        studentsRates.remove(student);
    }

    public static void printStudentsAndRatesBySubject() {
        studentsRates.forEach((student, subjectIntegerMap) -> {
            if (subjectIntegerMap != null) {
                System.out.println(student + " attends next subjects and has next rates ");
                subjectIntegerMap.forEach((subject, integer) -> System.out.println("   " + subject + " - rate " + integer));
            }
        });
    }
}

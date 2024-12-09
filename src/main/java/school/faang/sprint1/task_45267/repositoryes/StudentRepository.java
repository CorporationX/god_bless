package school.faang.sprint1.task_45267.repositoryes;

import school.faang.sprint1.task_45267.entityes.Student;
import school.faang.sprint1.task_45267.entityes.Subject;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private static final HashMap<Student, Map<Subject, Integer>> SUBJECTS_BY_STUDENT = new HashMap<>();

    public void addStudent(Student student, Map<Subject, Integer> subjects) {
        SUBJECTS_BY_STUDENT.putIfAbsent(student, subjects);
    }

    public boolean addSubjectToStudent(Student student, Subject subject, Integer grade) {
        if (SUBJECTS_BY_STUDENT.containsKey(student)) {
            SUBJECTS_BY_STUDENT.get(student).put(subject, grade);
            return true;
        }
        return true;
    }

    public boolean removeStudent(Student student) {
        if (SUBJECTS_BY_STUDENT.containsKey(student)) {
            SUBJECTS_BY_STUDENT.remove(student);
            return true;
        }
        return false;
    }

    public void printAllStudents() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : SUBJECTS_BY_STUDENT.entrySet()) {
            System.out.println(student.getKey());
            for (Map.Entry<Subject, Integer> subject : SUBJECTS_BY_STUDENT.get(student.getKey()).entrySet()) {
                System.out.println("- " + subject);
            }
        }
    }
}
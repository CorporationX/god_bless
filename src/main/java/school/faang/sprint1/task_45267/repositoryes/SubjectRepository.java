package school.faang.sprint1.task_45267.repositoryes;

import school.faang.sprint1.task_45267.entityes.Student;
import school.faang.sprint1.task_45267.entityes.Subject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubjectRepository {
    private static final HashMap<Subject, List<Student>> STUDENTS_BY_SUBJECT = new HashMap<>();

    public void addSubject(Student student, Map<Subject, Integer> subjects) {
        for (Map.Entry<Subject, Integer> subject : subjects.entrySet()) {
            STUDENTS_BY_SUBJECT.putIfAbsent(subject.getKey(), new LinkedList<>());
            STUDENTS_BY_SUBJECT.get(subject.getKey()).add(student);
        }

    }

    public boolean addStudentToSubject(Student student, Subject subject) {
        if (STUDENTS_BY_SUBJECT.containsKey(subject)) {
            if (STUDENTS_BY_SUBJECT.get(subject).contains(student)) {
                return false;
            }
        }
        STUDENTS_BY_SUBJECT.get(subject).add(student);
        return true;
    }

    public boolean removeStudentFromSubject(Student student, Subject subject) {
        if (STUDENTS_BY_SUBJECT.containsKey(subject)) {
            return STUDENTS_BY_SUBJECT.get(subject).remove(student);
        }
        return false;
    }

    public void printAllSubjects() {
        for (Map.Entry<Subject, List<Student>> subject : STUDENTS_BY_SUBJECT.entrySet()) {
            System.out.println(subject);
        }
    }
}
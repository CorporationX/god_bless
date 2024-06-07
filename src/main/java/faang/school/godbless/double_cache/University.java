package faang.school.godbless.double_cache;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class University {
    Map<Student, Map<Subject, Integer>> studentMarks;
    Map<Subject, List<Student>> subjectStudentMap;

    public void addNewStudentToUniversity(Student student, Map<Subject, Integer> marks) {
        studentMarks.put(student, marks);
    }

    public void addSubjectAndMarkToStudent(Student student, Subject subject, int mark) {
        studentMarks.computeIfAbsent(student, studentAsKey -> new HashMap<>()).put(subject, mark);
    }

    public void removeStudentAndMarks(Student student) {
        if (studentMarks.containsKey(student)) {
            studentMarks.remove(student);
        } else {
            log.warn("Could not find and remove student {}", student);
        }
    }

    public void showAllStudentsAndMarks() {
        for (Map.Entry<Student, Map<Subject, Integer>> studentEntry : studentMarks.entrySet()) {
            Student student = studentEntry.getKey();
            Map<Subject, Integer> marks = studentEntry.getValue();

            if (marks != null) {
                System.out.println("Marks of student: " + student);
                for (Map.Entry<Subject, Integer> marksEntry : marks.entrySet()) {
                    System.out.println("Subject: " + marksEntry.getKey());
                    System.out.println("Mark: " + marksEntry.getValue());
                }
            } else {
                log.warn("Student {} does not have information about marks", student);
            }
        }
    }

    public void addNewSubjectAndStudents(Subject subject, List<Student> students) {
        subjectStudentMap.put(subject, students);
    }

    public void addStudentToSubject(Subject subject, Student student) {
        subjectStudentMap.computeIfAbsent(subject, subjectAsKey -> new ArrayList<>()).add(student);
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (subjectStudentMap.containsKey(subject)) {
            subjectStudentMap.get(subject).remove(student);
        } else {
            log.warn("Could not find and remove student - {} from subject - {}", student, subject);
        }
    }

    public void showAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> subjectStudentEntry : subjectStudentMap.entrySet()) {
            Subject subject = subjectStudentEntry.getKey();
            List<Student> studentList = subjectStudentEntry.getValue();

            if (studentList != null) {
                System.out.println("Student of " + subject + ":");
                for (Student student : studentList) {
                    System.out.println(student);
                }
            } else {
                log.warn("Subject {} does not have any information about its students", subject);
            }
        }
    }
}

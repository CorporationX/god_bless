package school.faang.sprint1.bjs_45265;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final HashMap<Student, Map<Subject, Integer>> studentReport = new HashMap<>();
    private final HashMap<Subject, List<Student>> subjectEnrollment = new HashMap<>();

    public void addStudentRecords(Student student, Map<Subject, Integer> record) {
        if (student != null) {
            studentReport.put(student, record);
            for (Subject subject : record.keySet()) {
                subjectEnrollment.putIfAbsent(subject, new ArrayList<>());
                subjectEnrollment.get(subject).add(student);
            }
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> studentRecord = studentReport.get(student);
        if (studentRecord != null) {
            studentRecord.put(subject, grade);
            subjectEnrollment.putIfAbsent(subject, new ArrayList<>());
            subjectEnrollment.get(subject).add(student);
        }
    }

    public void deleteStudentRecords(Student student) {
        Map<Subject, Integer> recordForRemove = studentReport.remove(student);
        if (recordForRemove != null) {
            for (Subject subj : recordForRemove.keySet()) {
                List<Student> studentsList = subjectEnrollment.get(subj);
                studentsList.remove(student);
            }
        }
    }

    public void addNewSubjectRecord(Subject subject, List<Student> studentsList) {
        subjectEnrollment.put(subject, studentsList);
        for (Student student : studentsList) {
            studentReport.putIfAbsent(student, new HashMap<>());
            studentReport.get(student).put(subject, 0);
        }
    }

    public void addStudentEnrollment(Student student, Subject subject) {
        subjectEnrollment.get(subject).add(student);
        studentReport.putIfAbsent(student, new HashMap<>());
        studentReport.get(student).put(subject, 0);
    }

    public void printAllStudents() {
        for (var pair : studentReport.entrySet()) {
            String name = pair.getKey().getStudentName();
            System.out.print("Student name: " + name + " -> ");
            Map<Subject, Integer> record = pair.getValue();
            for (var entry : record.entrySet()) {
                System.out.println(" { Subject: " + entry.getKey().getSubjectName()
                        + " ; grade=" + entry.getValue() + " }");
            }
        }
    }
}

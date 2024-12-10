package school.faang.sprint1.bjs_45265;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final HashMap<Student, Map<Subject, Integer>> studentReport = new HashMap<>();
    private final HashMap<Subject, List<Student>> subjectEnrollment = new HashMap<>();

    public void addStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> record) {
        if (student != null) {
            studentReport.put(student, record);
            for (Subject subject : record.keySet()) {
                subjectEnrollment.computeIfAbsent(subject, key -> new ArrayList<>())
                        .add(student);
            }
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (student != null && subject != null) {
            studentReport.computeIfAbsent(student, key -> new HashMap<>())
                    .put(subject, grade);
            subjectEnrollment.computeIfAbsent(subject, key -> new ArrayList<>())
                    .add(student);
        }
    }

    public void deleteStudentRecords(Student student) {
        if (studentReport.containsKey(student)) {
            Map<Subject, Integer> recordForRemove = studentReport.remove(student);
            if (recordForRemove != null) {
                for (Subject subj : recordForRemove.keySet()) {
                    List<Student> studentsList = subjectEnrollment.get(subj);
                    studentsList.remove(student);
                }
            }
        }
    }

    public void deleteStudentFromSubjectList(Student student, Subject subject) {
        if (student != null && subject != null) {
            if (subjectEnrollment.containsKey(subject)) {
                subjectEnrollment.get(subject).remove(student);
            }
        }
    }


    public void addNewSubjectRecord(Subject subject, List<Student> studentsList) {
        if (subject != null) {
            subjectEnrollment.put(subject, studentsList);
            for (Student student : studentsList) {
                studentReport.computeIfAbsent(student, key -> new HashMap<>()).put(subject, 0);
            }
        }
    }

    public void addStudentEnrollment(Student student, Subject subject) {
        if (subject != null) {
            subjectEnrollment.get(subject).add(student);
            studentReport.putIfAbsent(student, new HashMap<>());
            studentReport.get(student).put(subject, 0);
        }
    }

    public void printAllStudents() {
        studentReport.forEach((student, record) -> {
            System.out.print("Student: " + student + " >> ");
            record.forEach((subj, grade) -> {
                System.out.println("{ Subject: " + subj + "; grade=" + grade + " }");
            });
        });
    }

    public void printAllSubjects() {
        subjectEnrollment.forEach((subj, studs) -> {
            System.out.print("Subject :" + subj + "-> Students: ");
            studs.forEach(System.out::print);
            System.out.println();
        });
    }
}

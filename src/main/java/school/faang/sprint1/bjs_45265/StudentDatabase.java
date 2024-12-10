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
                addStudentToSubjectList(subject, student);
            }
        }
    }

    public void addNewSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (student != null && subject != null) {
            addSubjectForStudent(student, subject, grade);
            addStudentToSubjectList(subject, student);
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

    public void deleteStudentFromSubjectList(Student student, Subject subject) {
        if (student != null && subject != null) {
            studentReport.remove(student);
            if (subjectEnrollment.containsKey(subject)) {
                subjectEnrollment.get(subject).remove(student);
            }
        }
    }

    public void addNewSubjectRecord(Subject subject, List<Student> studentsList) {
        if (subject != null) {
            subjectEnrollment.put(subject, studentsList);
            for (Student student : studentsList) {
                addSubjectForStudent(student, subject,0);
            }
        }
    }

    public void addStudentEnrollment(Student student, Subject subject) {
        if (subject != null) {
            addStudentToSubjectList(subject, student);
            addSubjectForStudent(student, subject, 0);
        }
    }

    public void addStudentToSubjectList(Subject subject, Student student) {
        subjectEnrollment.computeIfAbsent(subject, key -> new ArrayList<>())
                .add(student);
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        studentReport.computeIfAbsent(student, key -> new HashMap<>()).put(subject, grade);
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

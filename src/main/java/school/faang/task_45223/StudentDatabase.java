package school.faang.task_45223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentsGrade;
    private Map<Subject, List<Student>> studentsBySubject;

    public StudentDatabase() {
        studentsGrade = new HashMap<>();
        studentsBySubject = new HashMap<>();
    }

    public void removeStudentFromSubject(Subject subject, Student student) {
        if (studentsBySubject.containsKey(subject)) {
            List<Student> students = studentsBySubject.get(subject);
            students.remove(student);
        }
        if (studentsGrade.containsKey(student)) {
            Map<Subject, Integer> subjectIntegerMap = studentsGrade.get(student);
            if (subjectIntegerMap != null) {
                subjectIntegerMap.remove(subject);
            }
        }
    }

    public void addStudentToExistsSubject(Subject subject, Student student) {
        if (studentsBySubject.containsKey(subject)) {
            studentsBySubject.get(subject).add(student);
        } else {
            System.out.println("Subject not found");
            return;
        }
        if (studentsGrade.containsKey(student)) {
            studentsGrade.get(student).put(subject, null);
        } else {
            Map<Subject, Integer> map = new HashMap<>();
            map.put(subject, null);
            studentsGrade.put(student, map);
        }
    }

    public void addNewSubjectAndListStudents(Subject subject, List<Student> students) {
        List<Student> copyStudents = new ArrayList<>(students);
        studentsBySubject.put(subject, copyStudents);
        for (Student student : students) {
            if (studentsGrade.containsKey(student)) {
                studentsGrade.get(student).put(subject, null);
            } else {
                Map<Subject, Integer> map = new HashMap<>();
                map.put(subject, null);
                studentsGrade.put(student, map);
            }
        }
    }

    public void printStudentGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> student : studentsGrade.entrySet()) {
            System.out.print("Student: " + student.getKey().getName() + " subjects: ");
            for (Map.Entry<Subject, Integer> subject : student.getValue().entrySet()) {
                System.out.print(subject.getKey().getName() + " with grade: " + subject.getValue() + ", ");
            }
            System.out.println();
        }
    }

    public void printSubjects() {
        for (Map.Entry<Subject, List<Student>> subject : studentsBySubject.entrySet()) {
            System.out.print("The subject: " + subject.getKey().getName() + " contains students: ");
            for (Student student : subject.getValue()) {
                System.out.print(student.getName() + ", ");
            }
            System.out.println();
        }
    }

    public void removeStudentWithSubject(Student student) {
        if (studentsGrade.containsKey(student)) {
            Map<Subject, Integer> subjectMap = studentsGrade.get(student);
            for (Map.Entry<Subject, Integer> subject : subjectMap.entrySet()) {
                List<Student> students = studentsBySubject.get(subject.getKey());
                students.remove(student);
                if (students.isEmpty()) {
                    studentsBySubject.remove(subject.getKey());
                }
            }
            studentsGrade.remove(student);
        }
    }

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> grades) {
        // не сохраняю исходный map так как если извне передавать один и тот же мап двум разным
        // ученикам то получится их мапы связаны и потом меняя один мап то измените у другого
        Map<Subject, Integer> gradesCopy = new HashMap<>(grades);
        studentsGrade.put(student, gradesCopy);
        for (Subject subject : grades.keySet()) {
            if (studentsBySubject.containsKey(subject)) {
                studentsBySubject.get(subject).add(student);
            } else {
                List<Student> students = new ArrayList<>();
                students.add(student);
                studentsBySubject.put(subject, students);
            }
        }
    }

    public void addNewSubjectToExistStudent(Student student, Subject subject, int grade) {
        if (studentsGrade.containsKey(student)) {
            studentsGrade.get(student).put(subject, grade);
        } else {
            System.out.println("Student not found");
            return;
        }
        if (studentsBySubject.containsKey(subject)) {
            studentsBySubject.get(subject).add(student);
        } else {
            List<Student> students = new ArrayList<>();
            students.add(student);
            studentsBySubject.put(subject, students);
        }
    }
}

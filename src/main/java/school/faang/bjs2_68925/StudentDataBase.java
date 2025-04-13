package school.faang.bjs2_68925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDataBase {
    Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void newStudent(Student student, Map<Subject, Integer> subjectGrade) {
        studentSubjects.put(student, subjectGrade);
        for (Subject subject : subjectGrade.keySet()) {
            subjectStudents.computeIfAbsent(subject, a -> new ArrayList<>()).add(student);
        }
    }

    public void newSubjectForStud(Student student, Subject subject, int grade) {
        studentSubjects.computeIfAbsent(student, a -> new HashMap<>()).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, a -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student) {
        studentSubjects.remove(student);
        for (List<Student> students : subjectStudents.values()) {
            students.removeIf(s -> s.equals(student));
        }
    }

    public void printAllStud() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey().getName() + ": ");
            for (Map.Entry<Subject, Integer> subjGrade : entry.getValue().entrySet()) {
                System.out.println("Предмет: " + subjGrade.getKey().getName() + '\n'
                        + "Оценка: " + subjGrade.getValue());
            }
        }
    }

    public void newSubject(Subject subject, List<Student> students, List<Integer> grades) {
        subjectStudents.put(subject, students);
        for (int i = 0; i < students.size(); i++) {
            studentSubjects.computeIfAbsent(students.get(i), a -> new HashMap<>()).put(subject, grades.get(i));
        }
    }

    public void newStudentForSubj(Student student, Subject subject, int grade) {
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, a -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentFromSubj(Student student, Subject subject) {
        subjectStudents.get(subject).remove(student);
        studentSubjects.get(student).remove(subject);
    }

    public void printAllSubj() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.println("Урок: " + entry.getKey().getName());
            System.out.println("Ученики: ");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}

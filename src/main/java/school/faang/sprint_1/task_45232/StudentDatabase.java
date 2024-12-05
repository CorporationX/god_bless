package school.faang.sprint_1.task_45232;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.sprint_1.task_45232.Main.studentGrades;
import static school.faang.sprint_1.task_45232.Main.subjectStudents;

public class StudentDatabase {

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentGrades.put(student, grades);
        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.put(subject, grade);
            studentGrades.put(student, grades);
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> grades = studentGrades.remove(student);
        if (grades != null) {
            for (Subject subject : grades.keySet()) {
                List<Student> students = subjectStudents.get(subject);
                if (students != null) {
                    students.remove(student);
                }
            }
        }
    }

    public void printAllStudentsWithSubjects() {
        for (Map.Entry<Student, Map<Subject, Integer>> entryStudent : studentGrades.entrySet()) {
            Student student = entryStudent.getKey();
            Map<Subject, Integer> subjectMap = entryStudent.getValue();

            System.out.printf("Student: %s\n", student.getName());
            for (Map.Entry<Subject, Integer> entrySubject : subjectMap.entrySet()) {
                Subject subject = entrySubject.getKey();
                Integer grade = entrySubject.getValue();

                System.out.printf("  - Subject: %s, grade: %d\n", subject.getName(), grade);
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students) {
            studentGrades.putIfAbsent(student, new HashMap<>());
            studentGrades.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);
        studentGrades.putIfAbsent(student, new HashMap<>());
        studentGrades.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            students.remove(student);
        }
        Map<Subject, Integer> grades = studentGrades.get(student);
        if (grades != null) {
            grades.remove(subject);
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            Subject subject = entry.getKey();
            List<Student> students = entry.getValue();
            System.out.printf("Subject: %s", subject.getName());
            for (Student student : students) {
                System.out.println("  -" + student.getName());
            }
        }
    }

}


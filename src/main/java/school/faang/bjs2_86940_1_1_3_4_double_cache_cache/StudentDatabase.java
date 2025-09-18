package school.faang.bjs2_86940_1_1_3_4_double_cache_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addNewStudentInfo(Student student, Map<Subject, Integer> info) {
        studentSubjects.put(student, info);
        for (Subject subject : info.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<Student>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        studentSubjects.putIfAbsent(student, new HashMap<Subject, Integer>());
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.putIfAbsent(subject, new ArrayList<Student>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> deletingInfo = studentSubjects.remove(student);
        if (deletingInfo == null) {
            return;
        }
        for (Subject subject : deletingInfo.keySet()) {
            List<Student> students = subjectStudents.get(subject);
            if (students != null) {
                students.remove(student);
            }
        }
    }

    public void printStudentsWithGrades() {
        for (Student student : studentSubjects.keySet()) {
            System.out.println("Студент: " + student.getName());
            for (Map.Entry<Subject, Integer> entry : studentSubjects.get(student).entrySet()) {
                System.out.println("\tПредмет: " + entry.getKey().getName() + "\tоценка: " + entry.getValue());
            }
        }
    }

    public void addNewSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.put(subject, students);
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<Subject, Integer>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<Student>());
        if (!subjectStudents.get(subject).contains(student)) {
            subjectStudents.get(subject).add(student);
        }
        studentSubjects.putIfAbsent(student, new HashMap<Subject, Integer>());
        studentSubjects.get(student).put(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectStudents.get(subject);
        if (students != null) {
            subjectStudents.get(subject).remove(student);
        }
        Map<Subject, Integer> info = studentSubjects.get(student);
        if (info != null) {
            info.remove(subject);
        }
    }

    public void printSubjectsAndStudents() {
        for (Subject subject : subjectStudents.keySet()) {
            System.out.println("Предмет: " + subject.getName());
            for (Student student : subjectStudents.get(subject)) {
                System.out.println("\tСтудент: " + student.getName());
            }
        }
    }


}

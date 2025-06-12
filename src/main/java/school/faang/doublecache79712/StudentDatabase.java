package school.faang.doublecache79712;

import java.util.*;

public class StudentDatabase {

    public Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    public Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithGrades(Student student, Map<Subject, Integer> grades) {
        studentSubjects.putIfAbsent(student, grades);
        if (!studentSubjects.get(student).equals(grades)) {
            studentSubjects.get(student).putAll(grades);
        }

        for (Subject subject : grades.keySet()) {
            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade) {
        Map<Subject, Integer> map = studentSubjects.getOrDefault(student, new HashMap<>());
        map.put(subject, grade);
        studentSubjects.put(student, map);

        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);

    }

    public void removeStudent(Student student) {
        Map<Subject, Integer> map = studentSubjects.remove(student);
        for (Subject subject : map.keySet()) {
            subjectStudents.get(subject).remove(student);
        }
        Iterator<Subject> iterator = subjectStudents.keySet().iterator();
        while (iterator.hasNext()) {
            Subject subject = iterator.next();
            if (subjectStudents.get(subject).isEmpty()) {
                iterator.remove();
            }
        }
    }

    public void printAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()) {
            System.out.printf("Предмет %s:%n", entry.getKey());

            for (Student student : entry.getValue()) {
                System.out.printf("-Студент %s%n", student);
            }
        }
    }

    public void addSubjectWithStudents(Subject subject, List<Student> students) {
        subjectStudents.putIfAbsent(subject, students);
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            if (!students.contains(entry.getKey())) {
                students.add(entry.getKey());
            }
        }
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            if (!entry.getValue().containsKey(subject)) {
                entry.getValue().put(subject, null);
            }
        }
        for (Student student : students) {
            studentSubjects.putIfAbsent(student, new HashMap<>());
            studentSubjects.get(student).put(subject, null);
        }
    }

    public void addStudentToSubject(Student student, Subject subject) {
        subjectStudents.putIfAbsent(subject, new ArrayList<>());
        subjectStudents.get(subject).add(student);

        studentSubjects.putIfAbsent(student, new HashMap<>());
        studentSubjects.get(student).putIfAbsent(subject, null);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {

        if (subjectStudents.containsKey(subject)) {
            subjectStudents.get(subject).remove(student);

            if (subjectStudents.get(subject).isEmpty()) {
                subjectStudents.remove(subject);
            }
        }

        if (studentSubjects.containsKey(student)) {
            studentSubjects.get(student).remove(subject);

            if (studentSubjects.get(student).isEmpty()) {
                studentSubjects.remove(student);
            }
        }
    }
}


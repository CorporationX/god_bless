package school.faang.JavaHashMap.BJS2_32384;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Main {
    static Map<Student, Map<Subject, Integer>> subjectsAndGrades = new HashMap<>();
    static Map<Subject, List<Student>> studentsStudySubject = new HashMap<>();

    public static void main(String[] args) {
        addNewStudentWithSubjects(new Student(1, "John"), new Subject(1, "Mathematics"), 5);
        addNewStudentWithSubjects(new Student(2, "Emma"), new Subject(2, "Physics"), 4);
        addNewStudentWithSubjects(new Student(3, "Michael"), new Subject(3, "Chemistry"), 3);
        addNewStudentWithSubjects(new Student(4, "Sophia"), new Subject(4, "Biology"), 5);
        addNewStudentWithSubjects(new Student(5, "William"), new Subject(5, "History"), 4);
        addNewStudentWithSubjects(new Student(6, "Olivia"), new Subject(6, "English"), 5);
        addNewStudentWithSubjects(new Student(7, "James"), new Subject(7, "Computer Science"), 4);
        addNewStudentWithSubjects(new Student(8, "Ava"), new Subject(1, "Mathematics"), 3);
        addNewStudentWithSubjects(new Student(9, "Alexander"), new Subject(2, "Physics"), 5);
        addNewStudentWithSubjects(new Student(10, "Isabella"), new Subject(3, "Chemistry"), 4);

        addSubjectForStudent(new Student(1, "John"), new Subject(2, "Physics"), 4);
        addSubjectForStudent(new Student(2, "Emma"), new Subject(3, "Chemistry"), 3);
        addSubjectForStudent(new Student(3, "Michael"), new Subject(4, "Biology"), 5);
        addSubjectForStudent(new Student(4, "Sophia"), new Subject(5, "History"), 4);
        addSubjectForStudent(new Student(5, "William"), new Subject(6, "English"), 5);
        addSubjectForStudent(new Student(6, "Olivia"), new Subject(7, "Computer Science"), 4);
        addSubjectForStudent(new Student(7, "James"), new Subject(1, "Mathematics"), 3);

        removeStudent("John");

        System.out.println("Список всех студентов и их оценок:");
        printAllStudentsAndGrades();

        addNewSubjectWithStudents(new Subject(2, "Physics"), new Student(2, "Emma"));

        addStudentToSubject(new Student(3, "Michael"), new Subject(1, "Mathematics"));

        removeStudentFromSubject(new Student(1, "John"), new Subject(2, "Physics"));

        System.out.println("\nСписок всех предметов и студентов:");
        printAllSubjectsAndStudents();
    }

    public static void addNewStudentWithSubjects(Student student, Subject subject, Integer grade) {
        if (!subjectsAndGrades.containsKey(student)) {
            subjectsAndGrades.put(student, new HashMap<>());
        }
        subjectsAndGrades.get(student).put(subject, grade);

        if (!studentsStudySubject.containsKey(subject)) {
            studentsStudySubject.put(subject, new ArrayList<>());
        }
        if (!studentsStudySubject.get(subject).contains(student)) {
            studentsStudySubject.get(subject).add(student);
        }
    }

    public static void addSubjectForStudent(Student student, Subject subject, Integer grade) {
        if (!subjectsAndGrades.containsKey(student)) {
            subjectsAndGrades.put(student, new HashMap<>());
        }
        subjectsAndGrades.get(student).put(subject, grade);

        if (!studentsStudySubject.containsKey(subject)) {
            studentsStudySubject.put(subject, new ArrayList<>());
        }
        if (!studentsStudySubject.get(subject).contains(student)) {
            studentsStudySubject.get(subject).add(student);
        }
    }

    public static void removeStudent(String nameStudent) {
        Student studentToRemove = null;
        for (Student student : subjectsAndGrades.keySet()) {
            if (student.getName().equals(nameStudent)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            Map<Subject, Integer> removedSubjects = subjectsAndGrades.remove(studentToRemove);
            if (removedSubjects != null) {
                for (Subject subject : removedSubjects.keySet()) {
                    if (studentsStudySubject.containsKey(subject)) {
                        studentsStudySubject.get(subject).remove(studentToRemove);
                    }
                }
            }
            System.out.println("Студент " + nameStudent + " удален.");
        } else {
            System.out.println("Студент " + nameStudent + " не найден.");
        }
    }

    public static void printAllStudentsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : subjectsAndGrades.entrySet()) {
            System.out.println("Студент: " + entry.getKey());
            for (Map.Entry<Subject, Integer> subjectGrade : entry.getValue().entrySet()) {
                System.out.println("  Предмет: " + subjectGrade.getKey() + ", Оценка: " + subjectGrade.getValue());
            }
        }
    }

    public static void addNewSubjectWithStudents(Subject subject, Student student) {
        if (!studentsStudySubject.containsKey(subject)) {
            studentsStudySubject.put(subject, new ArrayList<>());
        }
        studentsStudySubject.get(subject).add(student);

        if (!subjectsAndGrades.containsKey(student)) {
            subjectsAndGrades.put(student, new HashMap<>());
        }
        subjectsAndGrades.get(student).put(subject, null);
    }

    public static void addStudentToSubject(Student student, Subject subject) {
        if (!studentsStudySubject.containsKey(subject)) {
            studentsStudySubject.put(subject, new ArrayList<>());
        }
        if (!studentsStudySubject.get(subject).contains(student)) {
            studentsStudySubject.get(subject).add(student);
        }
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        if (studentsStudySubject.containsKey(subject)) {
            studentsStudySubject.get(subject).remove(student);
        }
        if (subjectsAndGrades.containsKey(student)) {
            subjectsAndGrades.get(student).remove(subject);
        }
    }

    public static void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : studentsStudySubject.entrySet()) {
            System.out.println("Предмет: " + entry.getKey());
            System.out.println("Студенты:");
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
        }
    }
}

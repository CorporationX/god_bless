package school.faang.doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    public static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Map<Subject, Integer> subjects = new HashMap<>();

        Student student1 = new Student(1, "Student1");
        Student student2 = new Student(2, "Student2");
        Student student3 = new Student(3, "Student3");
        Subject subject1 = new Subject(1, "Subject1");
        Subject subject2 = new Subject(2, "Subject2");
        Subject subject3 = new Subject(3, "Subject3");

        subjects.put(subject1, 10);

        addStudentAndSubjects(student1, subjects);
        printStudentSubjects();
        subjects.put(subject2, 9);

        addStudentAndSubjects(student1, subjects);
        printStudentSubjects();
        printSubjectsAndStudents();

        addStudentAndSubjects(student1, Map.of(subject3, 8));
        printStudentSubjects();
        printSubjectsAndStudents();

        addStudentAndSubjects(student2, Map.of(subject3, 9));
        printStudentSubjects();
        printSubjectsAndStudents();

        addNewSubject(student2, subject1, 7);
        printStudentSubjects();
        printSubjectsAndStudents();

        addNewSubject(student3, subject1, 7);
        printStudentSubjects();
        printSubjectsAndStudents();

        deleteStudent(student2);
        printStudentSubjects();
        printSubjectsAndStudents();

        addNewSubject(subject1, List.of(student2, student1));
        addNewSubject(subject2, List.of(student2, student3));
        printSubjectsAndStudents();

        addNewStudentToSubjects(subject2, student1);
        printSubjectsAndStudents();

        addNewStudentToSubjects(subject3, student1);

        removeStudentFromSubjects(student1);
        printSubjectsAndStudents();

        removeStudentFromSubjects(student2);
        printSubjectsAndStudents();
    }

    //    добавление нового студента и его предметов с оценками
    public static void addStudentAndSubjects(Student student, Map<Subject, Integer> subjectAndMarks) {
        System.out.println("\n>> Adding student " + student.name() + " with list of subjects and marks ");
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).putAll(subjectAndMarks);
        for (Subject subj : subjectAndMarks.keySet()) {
            addNewSubject(subj, List.of(student));
        }
    }

    //    добавление нового предмета для существующего студента с оценкой
    public static void addNewSubject(Student student, Subject subj, Integer mark) {
        System.out.println("\n>> Adding new subject: " + subj + " and mark: " + mark + " for the existing student: " + student.name());
        if (studentSubjects.containsKey(student)) {
            studentSubjects.computeIfPresent(student, (key, subjects) -> {
                subjects.put(subj, mark);
                return subjects;
            });
            addNewSubject(subj, List.of(student));
        } else {
            System.out.println("\nStudent " + student.name() + " not found.");
        }
    }

    //    удаление студента и его предметов с оценками
    public static void deleteStudent(Student student) {
        System.out.println("\n>> Removing student " + student.name());
        Set<Subject> subjectsForStudent = studentSubjects.get(student).keySet();
        studentSubjects.remove(student);
        removeStudentFromSubjects(student, subjectsForStudent);
    }

    //    вывод списка всех студентов и их оценок по предметам
    public static void printStudentSubjects() {
        System.out.println("\nSTUDENTS LIST:");
        System.out.printf("| %-15s | %-15s | %-15s |%n", "Student:", "Subject:", "Mark:");
        for (Student student : studentSubjects.keySet()) {
            Map<Subject, Integer> subjects = studentSubjects.get(student);
            for (Subject subj : subjects.keySet())
                System.out.printf("| %-15s | %-15s | %-15s |%n", student.name(), subj.name(), subjects.get(subj));
        }
    }

    //    добавление нового предмета и списка студентов
    private static void addNewSubject(Subject subj, List<Student> students) {
        System.out.println("\n>> Adding new subject: " + subj.name() + " and list of students: " + students);
        subjectStudents.computeIfAbsent(subj, k -> new ArrayList<>()).addAll(
                students.stream()
                        .filter(student -> !subjectStudents.get(subj).contains(student))
                        .toList());
    }

    //    добавление студента к существующему предмету
    public static void addNewStudentToSubjects(Subject subj, Student student) {
        System.out.println("\n>> Adding new student: " + student + " to the existing subject: " + subj);
        subjectStudents.computeIfPresent(subj, (key, students) -> {
            students.add(student);
            return students;
        });
        if (!subjectStudents.containsKey(subj)) {
            System.out.println("\nSubject:" + subj.name() + " not found.");
        }
    }

    // удаление студента из предмета;
    public static void removeStudentFromSubjects(Student student) {
        System.out.println("\n>> Removing student: " + student + " from all subjects");
        Iterator<Map.Entry<Subject, List<Student>>> iterator = subjectStudents.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Subject, List<Student>> subjStudents = iterator.next();
            subjStudents.getValue().removeIf(item -> item.equals(student));
            if (subjStudents.getValue().isEmpty())
                iterator.remove();
        }
    }

    private static void removeStudentFromSubjects(Student student, Set<Subject> subjectsForStudent) {
        System.out.println("\n>> Removing student: " + student + " from all subjects - by list of specified subjects");
        for (Subject subj : subjectsForStudent) {
            subjectStudents.get(subj).removeIf(item -> item.equals(student));
            if (subjectStudents.get(subj).isEmpty()) {
                subjectStudents.remove(subj);
            }
        }
    }

    //    вывод списка всех предметов и студентов, изучающих их
    public static void printSubjectsAndStudents() {
        System.out.println("\nSUBJECTS LIST:");
        System.out.printf("| %-15s | %-30s |%n", "Subject:", "Students:");
        for (Subject subject : subjectStudents.keySet()) {
            System.out.printf("| %-15s | %-30s |%n", subject.name(), subjectStudents.get(subject));
        }
    }
}

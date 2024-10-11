package school.faang.cashdoublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> studentAndSubjectMap = new HashMap<>();
    private static Map<Subject, List<Student>> subjectMapAndStudentList = new HashMap<>();
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        // добавление нового студента и его предметов с оценками;
        addStudentAndSubjects(1, "Jake", 1, "Biology", 5);;
        addStudentAndSubjects(1, "Jake", 2, "Biology", 5);
        addStudentAndSubjects(2, "Bob", 3, "Psychology", 5);
        addStudentAndSubjects(3,"Bill",3, "Art", 5);

        // добавление предмета
        addSubjectForStudent(1,"Jake", 4, "Chemistry", 4);

        // удаление студента
        deleteStudentsAndSubjects(3, "Bill");

        // вывод списка всех студентов и их оценок по предметам.
        printAllStudent();

        // добавление предмета и студентов
        students.add(new Student(1,"Jake"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Den"));

        addSubjectAndStudent(1, "Accounting", students);

        // добавление студента в конкретный предмет
        addStudentInSubject(1, "Accounting",4,"Bill");

        deleteStudentInSubject(1, "Accounting", 2, "Bob");
        printAllSubjectsAndStudents();
    }

    private static void addStudentAndSubjects(Integer studentId, String studentName, Integer subjectId,
                                              String subjectName, Integer gradeSubject) {
        Student student = new Student(studentId, studentName);
        Subject subject = new Subject(subjectId, subjectName);
        if (!studentAndSubjectMap.containsKey(student)) {
            Map<Subject, Integer> subjectMap = new HashMap<>();
            subjectMap.put(subject, gradeSubject);
            studentAndSubjectMap.put(student, subjectMap);
        } else {
            //System.out.println("Такой пользователь уже есть");
            Map<Subject, Integer> subjectMap = studentAndSubjectMap.get(student);
            subjectMap.put(subject, gradeSubject);
        }
    }

    private static void addSubjectForStudent(Integer studentId, String studentName, Integer subjectId,
                                             String subjectName, Integer gradeSubject) {
        Student student = new Student(studentId, studentName);
        Subject subject = new Subject(subjectId, subjectName);
        if (studentAndSubjectMap.containsKey(student)) {
            Map<Subject, Integer> subjectMap = studentAndSubjectMap.get(student);
            subjectMap.put(subject, gradeSubject);
        }
    }

    private static void deleteStudentsAndSubjects(Integer studentId, String studentName) {
        if (studentAndSubjectMap.get(new Student(studentId, studentName)) == null) {
            System.out.println("Не можем удалить, такого студента нет");
        }
        studentAndSubjectMap.remove(new Student(studentId, studentName));
    }

    private static void printAllStudent() {
        studentAndSubjectMap.forEach((student, subjectMap) -> {
            System.out.println(" ");
            System.out.println("Имя студента: " + student.studentName() + ", Id студента: " + student.studentId());
                subjectMap.forEach((subject, grade) -> {
                    System.out.println("Id предмета: " + subject.subjectId() + ", Название предмета: " + subject.subjectName() + ", Оценка: " + grade);
                });
        });
    }

    private static void addSubjectAndStudent(Integer subjectId, String subjectName, List<Student> students) {
        subjectMapAndStudentList.put(new Subject(subjectId, subjectName), students);
    }

    private static void addStudentInSubject(Integer subjectId, String subjectName, Integer studentId, String studentName) {
        if (subjectMapAndStudentList.containsKey(new Subject(subjectId, subjectName))) {
            students.add(new Student(studentId, studentName));
        } else {
            System.out.println("Такого предмета нет");
        }
    }

    private static void deleteStudentInSubject(Integer subjectId, String subjectName, Integer studentId, String studentName) {
        if (!students.contains(new Student(studentId, studentName))) {
            System.out.println("Нет такого студента, не можем удалить");
        }

        if (subjectMapAndStudentList.containsKey(new Subject(subjectId, subjectName))) {
            students.remove(new Student(studentId, studentName));
        } else {
            System.out.println("Такого предмета нет");
        }
    }

    private static void printAllSubjectsAndStudents() {
        subjectMapAndStudentList.forEach(((subject, studentsList) -> {
                System.out.println(" ");
                System.out.println("Id предмета: " + subject.subjectId() + ", Название предмета: " + subject.subjectName());
                studentsList.forEach(student ->
                                System.out.println("Id Студента: " + student.studentId() + ", Имя студента: " + student.studentName()));
        }));
    }
}

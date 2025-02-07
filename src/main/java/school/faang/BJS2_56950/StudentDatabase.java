package school.faang.BJS2_56950;

import java.util.*;

public class StudentDatabase {
    private static final String RAMIL = "Ramil";
    private static final String ALBERT = "Albert";
    private static final String KAMIL = "Kamil";
    private static final String MATH = "Math";
    private static final String ART = "Art";

    public static void main(String[] args) {
        System.out.printf("Работа с переменной studentSubjects ");
        addStudentAndSubjectWithInteger(RAMIL, MATH, 3);
        addStudentAndSubjectWithInteger(ALBERT, MATH, 5);
        showStudentWithSubject();
        addNewSubjectWithInteger(RAMIL, ART, 2);
        addNewSubjectWithInteger(ALBERT, ART, 5);
        showStudentWithSubject();
        deleteStudent(RAMIL);
        showStudentWithSubject();

        System.out.printf("%nРабота с переменной subjectStudents");
        addNewSubjectWithStudents(new HashSet<>(Set.of(RAMIL, ALBERT)), MATH);
        showSubjectWithStudent();
        addNewStudentForSubject(KAMIL, MATH);
        showSubjectWithStudent();
        deleteStudentFromSubject(ALBERT, MATH);
        showSubjectWithStudent();
    }

    private static final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private static final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    private static void addStudentAndSubjectWithInteger(String studentName, String subjectName, int integer) {
        Student key = new Student(studentName);
        Map<Subject, Integer> value = new HashMap<>(Map.of(new Subject(subjectName), integer));

        studentSubjects.put(key, value);
    }

    private static Student findStudent(String studentName) {
        Student student = new Student(studentName);

        if (!studentSubjects.containsKey(student)) {
            System.out.printf("Студента с  именем %s нету в списке студентов", studentName);
            return null;
        }

        return student;
    }

    private static void addNewSubjectWithInteger(String studentName, String subjectName, int integer) {
        Student student = findStudent(studentName);

        if (student == null) {
            return;
        }

        Map<Subject, Integer> mapSubject = studentSubjects.get(student);
        mapSubject.put(new Subject(subjectName), integer);
    }


    private static void deleteStudent(String studentName) {
        Student student = findStudent(studentName);

        if (student == null) {
            return;
        }

        studentSubjects.remove(student);
    }

    private static void showStudentWithSubject() {
        studentSubjects.forEach((student, subjectMap) -> {
            System.out.printf("%nИмя студенда %s%n", student.getName());
            System.out.printf("Предметы:%n");
            subjectMap.forEach((subject, integer) -> {
                System.out.printf("- Предмет %-10s | Оценка: %-3s %n", subject.getName(), integer);
            });

        });
    }

    private static void addNewSubjectWithStudents(Set<String> students, String subjectName) {
        Subject subject = new Subject(subjectName);
        List<Student> value = new ArrayList<>();

        students.forEach(studentName -> value.add(new Student(studentName)));
        subjectStudents.put(subject, value);
    }

    private static Subject findSubject(String subjectName) {
        Subject subject = new Subject(subjectName);

        if (!subjectStudents.containsKey(subject)) {
            System.out.printf("Предмета с названием %s нету в subjectStudents ", subjectName);
        }

        return subject;
    }

    private static void addNewStudentForSubject(String studentName, String subjectName) {
        Subject subject = findSubject(subjectName);

        if (subject == null) {
            return;
        }
        subjectStudents.get(subject).add(new Student(studentName));
    }

    private static void deleteStudentFromSubject(String studentName, String subjectName) {
        Subject subject = findSubject(subjectName);
        
        if (subject == null) {
            return;
        }

        subjectStudents.get(subject).remove(new Student(studentName));
    }

    private static void showSubjectWithStudent() {
        subjectStudents.forEach((subject, studentList) -> {
            System.out.printf("%nПредмет: %s%n", subject.getName());
            System.out.printf("Студенты изучающий предмет:%n");
            studentList.forEach(student -> {
                System.out.printf("Имя студента: %s%n", student.getName());
            });

        });
    }

}

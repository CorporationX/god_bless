package school.faang.doublecache;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityDB {
    public static final int MIN_MARK = 1;
    public static final int MAX_MARK = 5;

    private final Map<Student, Map<Subject, Integer>> studentToSubject = new HashMap<>();
    private final Map<Subject, List<Student>> subjectToStudent = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Коля");
        Student student2 = new Student(2, "Костя");
        Student student3 = new Student(3, "Андрей");

        Subject subject1 = new Subject(1, "Тервер");
        Subject subject2 = new Subject(2, "Линал");
        Subject subject3 = new Subject(3, "Дискретная математика");
        Subject subject4 = new Subject(4, "Архитектура ПО");

        Map<Subject, Integer> subjectToMark1 = new HashMap<>();
        subjectToMark1.put(subject1, 5);
        subjectToMark1.put(subject2, 4);
        subjectToMark1.put(subject3, 5);

        Map<Subject, Integer> subjectToMark2 = new HashMap<>();
        subjectToMark2.put(subject1, 2);
        subjectToMark2.put(subject2, 1);
        subjectToMark2.put(subject3, 5);

        Map<Subject, Integer> subjectToMark3 = new HashMap<>();
        subjectToMark2.put(subject1, 4);
        subjectToMark2.put(subject2, 4);
        subjectToMark2.put(subject3, 4);


        UniversityDB universityDB = new UniversityDB();

        //Добавление студента
        universityDB.addStudent(student1, subjectToMark1);
        universityDB.addStudent(student2, subjectToMark2);
        universityDB.addStudent(student3, subjectToMark3);
        universityDB.printMarksByStudent();
        System.out.println();

        //Добавление нового предмета и списка студентов
        List<Student> students = new ArrayList<>(List.of(student1, student2, student3));
        universityDB.addSubject(subject1, students);
        universityDB.addSubject(subject2, students);
        universityDB.addSubject(subject3, students);
        universityDB.printStudentsBySubject();
        System.out.println();

        universityDB.addSubjectToStudent(student3, subject4, 2);
        universityDB.addStudentToSubject(student3, subject4);

        //удаление студента
        universityDB.removeStudent(student1);
        universityDB.printMarksByStudent();
        System.out.println();

        //удаление студента из предмета
        universityDB.removeStudentFromSubject(student3, subject4);
        universityDB.printMarksByStudent();
    }

    public void addStudent(@NonNull Student student, @NonNull Map<Subject, Integer> subjectToMark) {
        studentToSubject.put(student, subjectToMark);
    }

    public void addSubject(@NonNull Subject subject, @NonNull List<Student> students) {
        subjectToStudent.put(subject, students);

    }

    public void addSubjectToStudent(@NonNull Student student, @NonNull Subject subject, int mark) {
        if (mark < MIN_MARK || mark > MAX_MARK) {
            throw new IllegalArgumentException("У нас пятибальная шкала");
        }
        if (!studentToSubject.containsKey(student)) {
            throw new IllegalArgumentException("Student " + student + " does not exist");
        }
        Map<Subject, Integer> subjectToMark = studentToSubject.get(student);
        subjectToMark.put(subject, mark);
    }

    public void addStudentToSubject(@NonNull Student student, @NonNull Subject subject) {
        List<Student> students = subjectToStudent.getOrDefault(subject, new ArrayList<>());
        students.add(student);
        subjectToStudent.put(subject, students);
    }

    public void removeStudent(Student student) {
        studentToSubject.remove(student);
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
        List<Student> students = subjectToStudent.get(subject);
        if (students == null) {
            return;
        }
        students.removeIf(student::equals);
        if (students.isEmpty()) {
            subjectToStudent.remove(subject);
        } else {
            subjectToStudent.put(subject, students);
        }
    }

    public void printMarksByStudent() {
        studentToSubject.forEach((student, subjects) -> System.out.println(student + ": " + subjects.values()));
    }

    public void printStudentsBySubject() {
        subjectToStudent.forEach((subject, students) -> System.out.println(subject + ": " + students));
    }
}

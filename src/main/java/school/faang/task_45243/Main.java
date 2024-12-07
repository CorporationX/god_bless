package school.faang.task_45243;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Subject[] SUBJECTS = new Subject[]{
            new Subject(1, "Mathematics"),
            new Subject(2, "Physics"),
            new Subject(3, "Chemistry"),
            new Subject(4, "Biology"),
            new Subject(5, "English"),
            new Subject(6, "History"),
            new Subject(7, "Computer Science"),
            new Subject(8, "Geography"),
            new Subject(9, "Art"),
            new Subject(10, "Music")
    };
    private static final int MAX_GRADE = 100;

    private static final StudentDatabase studentDb = new StudentDatabase();

    public static void main(String[] args) {
        initData();

        Student user = new Student(11, "User");
        Subject userSubject = new Subject(11, "Java");

        studentDb.addStudentWithGrades(user, generateRandomSubjectsWithGrades());
        studentDb.addSubjectForStudent(user, userSubject, 99);

        studentDb.printAllSubjectsWithStudents();
        System.out.println();

        studentDb.removeStudent(user);
        System.out.println("--------------------");

        studentDb.printAllSubjectsWithStudents();
    }

    private static void initData() {
        studentDb.addStudentWithGrades(new Student(1, "Alice Johnson"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(2, "Bob Smith"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(3, "Charlie Brown"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(4, "David Lee"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(5, "Eva Davis"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(6, "Frank Wilson"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(7, "Grace Martinez"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(8, "Henry Thompson"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(9, "Isabella Garcia"), generateRandomSubjectsWithGrades());
        studentDb.addStudentWithGrades(new Student(10, "Jack Martinez"), generateRandomSubjectsWithGrades());
    }

    private static Subject getRandomSubject() {
        return SUBJECTS[(int) (Math.random() * (SUBJECTS.length))];
    }

    private static int getRandomGrade() {
        return (int) (Math.random() * (MAX_GRADE + 1));
    }

    private static Map<Subject, Integer> generateRandomSubjectsWithGrades() {
        Map<Subject, Integer> map = new HashMap<>();
        for (int i = 0; i < SUBJECTS.length; i++) {
            map.put(getRandomSubject(), getRandomGrade());
        }

        return map;
    }
}

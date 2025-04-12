package school.faang.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Subject math = new Subject("Математика");
        Subject fiz = new Subject("Физика");
        Subject russia = new Subject("Русский");
        Subject biology = new Subject("Биологи");

        Student oleg = new Student("Олег");
        Student alex = new Student("Алексей");
        Student egor = new Student("Егор");

        Map<Subject, Integer> subjectAndBallForOleg = new HashMap<>();
        Map<Subject, Integer> subjectAndBallForAlex = new HashMap<>();
        Map<Subject, Integer> subjectAndBallForEgor = new HashMap<>();

        subjectAndBallForOleg.put(math, 3);
        subjectAndBallForOleg.put(russia, 5);
        subjectAndBallForEgor.put(biology, 4);
        subjectAndBallForAlex.put(math, 5);
        subjectAndBallForAlex.put(biology, 5);
        subjectAndBallForAlex.put(fiz, 4);
        subjectAndBallForAlex.put(russia, 5);

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addNewStudentAndSubjectAWithBall(oleg, subjectAndBallForOleg);
        studentDatabase.addNewStudentAndSubjectAWithBall(alex, subjectAndBallForAlex);
        studentDatabase.addNewStudentAndSubjectAWithBall(egor, subjectAndBallForEgor);

//        studentDatabase.printAllStudentAndSubjectWithBall();

        studentDatabase.addSubjectWithBallForOldStudent(egor, math, 3);
//        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));
        System.out.println(studentDatabase.getSubjectStudents().get(fiz));

        studentDatabase.removeStudentAndYouSubject(alex);

        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));
        System.out.println(studentDatabase.getSubjectStudents().get(fiz));

        // неккорректно формируется list студентов во втором мап
    }
}


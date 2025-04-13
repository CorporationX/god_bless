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

        Map<Subject, Ball> subjectAndBallForOleg = new HashMap<>();
        Map<Subject, Ball> subjectAndBallForAlex = new HashMap<>();
        Map<Subject, Ball> subjectAndBallForEgor = new HashMap<>();

        subjectAndBallForOleg.put(math, Ball.THREE);
        subjectAndBallForOleg.put(russia, Ball.TWO);
        subjectAndBallForEgor.put(biology, Ball.FOUR );
        subjectAndBallForAlex.put(math, Ball.FIVE);
        subjectAndBallForAlex.put(biology, Ball.FIVE);
        subjectAndBallForAlex.put(fiz, Ball.FOUR);
        subjectAndBallForAlex.put(russia, Ball.FIVE);

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addNewStudentAndSubjectAWithBall(oleg, subjectAndBallForOleg);
        studentDatabase.addNewStudentAndSubjectAWithBall(alex, subjectAndBallForAlex);
        studentDatabase.addNewStudentAndSubjectAWithBall(egor, subjectAndBallForEgor);

//        studentDatabase.printAllStudentAndSubjectWithBall();

        studentDatabase.addSubjectWithBallForOldStudent(egor, math, Ball.THREE);
//        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));
        System.out.println(studentDatabase.getSubjectStudents().get(fiz));

        studentDatabase.removeStudentAndYouSubject(alex);

        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));
        System.out.println(studentDatabase.getSubjectStudents().get(fiz));

        studentDatabase.printAllSubjectWithStudent();
    }
}


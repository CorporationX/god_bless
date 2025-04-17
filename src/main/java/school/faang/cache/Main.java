package school.faang.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Subject math = new Subject("Математика");
        Subject russia = new Subject("Русский");
        Subject biology = new Subject("Биологи");
        Student student1 = new Student("Олег");
        Student student2 = new Student("Алекс");

        Map<Subject, Ball> subjectAndBallForOleg = new HashMap<>();
        Map<Subject, Ball> subjectAndBallForAlex = new HashMap<>();

        subjectAndBallForOleg.put(math, Ball.THREE);
        subjectAndBallForOleg.put(russia, Ball.TWO);
        subjectAndBallForAlex.put(math, Ball.FIVE);
        subjectAndBallForAlex.put(biology, Ball.FIVE);
        subjectAndBallForAlex.put(russia, Ball.FIVE);

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addNewStudentAndSubjectWithBall(student1, subjectAndBallForOleg);
        studentDatabase.addNewStudentAndSubjectWithBall(student2, subjectAndBallForAlex);

        studentDatabase.printAllStudentAndSubjectWithBall();

        studentDatabase.addSubjectWithBallForOldStudent(student2, math, Ball.THREE);
        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));

        studentDatabase.removeStudentAndYouSubject(student1);

        studentDatabase.printAllStudentAndSubjectWithBall();

        System.out.println(studentDatabase.getSubjectStudents().get(biology));

        studentDatabase.printAllSubjectWithStudent();
    }
}


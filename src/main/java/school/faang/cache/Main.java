package school.faang.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        StudentDatabase studentDatabase = new StudentDatabase();

        Subject math = new Subject("Математика");
        Subject russia = new Subject("Русский");
        Subject biology = new Subject("Биологи");
        Student student1 = new Student("Олег");
        Student student2 = new Student("Алекс");

        Map<Subject, Ball> subjectAndBallForOleg = new HashMap<>(Map.of(math, Ball.THREE, russia, Ball.TWO));
        Map<Subject, Ball> subjectAndBallForAlex = new HashMap<>(Map.of(math, Ball.FIVE,
                biology, Ball.FIVE, russia, Ball.FIVE));

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


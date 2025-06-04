package school.faang.bjs2_79673;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("-----------Unit Testing-----------");

        Student student1 = new Student("Steve");
        Student student2 = new Student("Mike");
        Student student3 = new Student("Jonh");

        Subject subject1 = new Subject("Математический анализ");
        Subject subject2 = new Subject("Геометрия и топология");
        Subject subject3 = new Subject("Дискретный анализ");

        Map<Subject, Grade> logOfMarks1 = new HashMap<>();
        logOfMarks1.put(subject1, Grade.C);
        logOfMarks1.put(subject3, Grade.D);
        logOfMarks1.put(subject2, Grade.D);

        Map<Subject, Grade> logOfMarks2 = new HashMap<>();
        logOfMarks2.put(subject1, Grade.D);
        logOfMarks2.put(subject2, Grade.E);

        Map<Subject, Grade> logOfMarks3 = new HashMap<>();
        logOfMarks3.put(subject3, Grade.C);

        log.info("-----------Testing add method-----------");
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithSubjectsAndGrades(student1, logOfMarks1);
        studentDatabase.addStudentWithSubjectsAndGrades(student2, logOfMarks2);
        studentDatabase.addStudentWithSubjectsAndGrades(student3, logOfMarks3);

        log.info(String.valueOf(studentDatabase));

        log.info("-----------Testing update subject method-----------");


    }
}

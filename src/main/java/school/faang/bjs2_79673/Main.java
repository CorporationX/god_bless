package school.faang.bjs2_79673;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("-----------Testing-----------");

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
        Student student1 = new Student("Steve");
        Student student2 = new Student("Mike");
        Student student3 = new Student("Jonh");

        studentDatabase.addStudentWithSubjectsAndGrades(student1, logOfMarks1);
        studentDatabase.addStudentWithSubjectsAndGrades(student2, logOfMarks2);
        studentDatabase.addStudentWithSubjectsAndGrades(student3, logOfMarks3);
        studentDatabase.printAll();


        log.info("-----------Testing update subject method-----------");
        studentDatabase.addSubjectWithGradeToStudent(student3, new Subject("Предмет новый"), Grade.C);
        studentDatabase.addSubjectWithGradeToStudent(student3, new Subject("Предмет новый"), Grade.C);
        studentDatabase.addSubjectWithGradeToStudent(student2, new Subject("Предмет новый"), Grade.C);
        studentDatabase.addSubjectWithGradeToStudent(student2, new Subject("Предмет новый"), Grade.A);
        studentDatabase.printAll();


        log.info("-----------Testing remove method-----------");
        studentDatabase.removeStudent(student1);
        studentDatabase.removeStudent(student1);
        studentDatabase.printAll();
        System.out.println();
        studentDatabase.removeStudent(student2);
        studentDatabase.removeStudent(student3);
        studentDatabase.printAll();
    }
}

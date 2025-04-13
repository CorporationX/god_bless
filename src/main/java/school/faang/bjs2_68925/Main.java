package school.faang.bjs2_68925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Student vasya = new Student("вася");
        final Student anton = new Student("антон");
        final Student carolina = new Student("каролина");
        Subject math = new Subject("Математика");
        Subject english = new Subject("Английский");
        StudentDataBase studentDataBase = new StudentDataBase();
        Map<Subject, Integer> test = new HashMap<>();
        test.put(math, 5);
        //тесты
        studentDataBase.newStudent(vasya, test);
        studentDataBase.newSubjectForStud(vasya, english, 4);
        studentDataBase.printAllStud();
        studentDataBase.removeStudent(vasya);
        studentDataBase.newStudent(anton, test);
        studentDataBase.newSubjectForStud(anton, english, 12);
        studentDataBase.printAllStud();
        List<Student> studList = new ArrayList<>();
        studList.add(anton);
        studList.add(vasya);
        studentDataBase.newSubject(english, studList, List.of(3, 4));
        studentDataBase.newStudentForSubj(carolina, english, 5);
        studentDataBase.newSubjectForStud(anton, math, 5);
        studentDataBase.printAllSubj();
        studentDataBase.removeStudentFromSubj(anton, english);
        studentDataBase.printAllSubj();
        studentDataBase.printAllStud();
    }
}

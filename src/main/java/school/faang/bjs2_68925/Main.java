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
        studentDataBase.removeStudentFromSubject(vasya, english);
        //тесты
        studentDataBase.newStudent(vasya, test);
        studentDataBase.newSubjectForStudent(vasya, english, 4);
        studentDataBase.printAllStudents();
        studentDataBase.removeStudent(vasya);
        studentDataBase.newStudent(anton, test);
        studentDataBase.newSubjectForStudent(anton, english, 12);
        studentDataBase.printAllStudents();
        List<Student> studList = new ArrayList<>();
        studList.add(anton);
        studList.add(vasya);
        studentDataBase.addNewSubject(english, studList, List.of(3, 4));
        studentDataBase.newStudentForSubj(carolina, english, 5);
        studentDataBase.newSubjectForStudent(anton, math, 5);
        studentDataBase.printAllSubj();
        studentDataBase.removeStudentFromSubject(anton, english);
        studentDataBase.printAllSubj();
        studentDataBase.printAllStudents();
    }
}

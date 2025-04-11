package school.faang.doubleCache;

import lombok.extern.slf4j.Slf4j;
import school.faang.doubleCache.model.Student;
import school.faang.doubleCache.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static StudentDatabase studentDatabase = new StudentDatabase();

    public static void main(String[] args) {
        Student vlad = new Student("Vladislav");
        Map<Subject, Integer> studentSubjects = new HashMap<>();
        Subject physics = new Subject("Physics");
        Subject math = new Subject("Math");
        studentSubjects.put(math, 5);
        studentSubjects.put(physics, 3);
        studentDatabase.addStudent(vlad, studentSubjects);

        String information = studentDatabase.getStudentMarks();

        System.out.println(information);

        /*Student vlad = new Student("Vladislav");

        Map<Subject, Integer> studentSubjects = new HashMap<>();
        studentSubjects.put(new Subject("Math"), 5);
        studentSubjects.put(new Subject("Physics"), 3);

        studentDatabase.addStudent(vlad, studentSubjects);
        studentDatabase.addSubjectForExistingStudent(new Subject("Biology"), 5, vlad);
        //studentDatabase.deleteStudent(vlad);

        log.info("Students - [{}]", studentDatabase.getStudentMarks());

        List<Student> historyStudents = new ArrayList<>();
        historyStudents.add(vlad);
        Subject history = new Subject("History");
        studentDatabase.addSubject(history, historyStudents);

        Student andrej = new Student("Andrej");
        studentDatabase.addStudentToExistingSubject(andrej, history, 3);
        //studentDatabase.addStudentToExistingSubject(andrej, new Subject("Geography"), 3);

        studentDatabase.deleteStudentFromSubject(new Student("Alisa"), history);*/
    }
}

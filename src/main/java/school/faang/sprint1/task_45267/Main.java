package school.faang.sprint1.task_45267;

import school.faang.sprint1.task_45267.Entityes.Student;
import school.faang.sprint1.task_45267.Entityes.Subject;
import school.faang.sprint1.task_45267.services.MainService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        Map<Subject, Integer> oneSubjectMap = new HashMap<>();

        Subject subject1 = new Subject("subject 1");
        Subject subject2 = new Subject("subject 2");
        Subject subject3 = new Subject("subject 3");
        Student student1 = new Student("student1");
        Student student2 = new Student("student2");
        Student student3 = new Student("student3");

        oneSubjectMap.put(subject1, new Random().nextInt(1, 100));
        mainService.addStudentWithSubject(student1, randomSubjectGradesFactory(subject1, subject2, subject3));
        mainService.addStudentWithSubject(student2, randomSubjectGradesFactory(subject1, subject2, subject3));
        mainService.addStudentWithSubject(student3, oneSubjectMap);


        System.out.println(mainService.JoinStudentAndSubject(student3, subject2, 34));

        System.out.println(mainService.removeStudent(student2, subject1));

        mainService.printAllStudentsAndSubjects();

    }

    public static Map<Subject, Integer> randomSubjectGradesFactory(Subject subject1, Subject subject2, Subject subject3) {
        Map<Subject, Integer> subjects = new HashMap<>();

        subjects.put(subject2, new Random().nextInt(1, 100));
        subjects.put(subject1, new Random().nextInt(1, 100));
        subjects.put(subject3, new Random().nextInt(1, 100));

        return subjects;
    }
}

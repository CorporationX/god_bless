package faang.school.godbless.streamAPI.diary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Student 1
        Student student1 = new Student("John", "Doe");
        Map<String, List<Integer>> courses1 = new HashMap<>();
        courses1.put("Math", Arrays.asList(4, 5, 4));
        courses1.put("Physics", Arrays.asList(3, 4, 3));
        courses1.put("History", Arrays.asList(3, 3, 3));
        student1.setCourses(courses1);
        students.add(student1);

        // Student 2
        Student student2 = new Student("Alice", "Smith");
        Map<String, List<Integer>> courses2 = new HashMap<>();
        courses2.put("Math", Arrays.asList(5, 5, 4));
        courses2.put("Physics", Arrays.asList(4, 4, 4));
        courses2.put("History", Arrays.asList(3, 3, 3));
        student2.setCourses(courses2);
        students.add(student2);

        // Student 3
        Student student3 = new Student("Bob", "Johnson");
        Map<String, List<Integer>> courses3 = new HashMap<>();
        courses3.put("Math", Arrays.asList(3, 4, 3));
        courses3.put("Physics", Arrays.asList(4, 4, 3));
        courses3.put("History", Arrays.asList(3, 3, 3));
        student3.setCourses(courses3);
        students.add(student3);

        // Student 4
        Student student4 = new Student("Emma", "Davis");
        Map<String, List<Integer>> courses4 = new HashMap<>();
        courses4.put("Math", Arrays.asList(5, 5, 5));
        courses4.put("Physics", Arrays.asList(4, 5, 4));
        courses4.put("History", Arrays.asList(3, 3, 3));
        student4.setCourses(courses4);
        students.add(student4);

        // Student 5
        Student student5 = new Student("Michael", "Brown");
        Map<String, List<Integer>> courses5 = new HashMap<>();
        courses5.put("Math", Arrays.asList(4, 4, 3));
        courses5.put("Physics", Arrays.asList(3, 3, 3));
        courses5.put("History", Arrays.asList(3, 3, 3));
        student5.setCourses(courses5);
        students.add(student5);


        DiaryService diary = new DiaryService();

        System.out.println("\nAverage marks for all subjects:\n" + diary.getAverageMarks(students).orElse(new HashMap<>()));

        var firstName = "Michael";
        var lastName = "Brown";
        System.out.println("\nFinal grades of student " + firstName + " " + lastName + ": ");
        System.out.println(diary.getFinalGrades(students, firstName, lastName));

        System.out.println("\nMost challenging subject: " + diary.getMostChallengingSubject(students).orElse("Input list was null."));
    }
}

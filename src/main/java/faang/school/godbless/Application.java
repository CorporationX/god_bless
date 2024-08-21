package faang.school.godbless;

import faang.school.godbless.Notification.Notification;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Map<String, List<Integer>> courses1 = new HashMap<>();
        courses1.put("Math", Arrays.asList(5, 4, 4));
        courses1.put("Chemistry", Arrays.asList(3, 2));
        courses1.put("Physics", Arrays.asList(5, 4, 3));

        Map<String, List<Integer>> courses2 = new HashMap<>();
        courses2.put("Math", Arrays.asList(4, 5));
        courses2.put("Chemistry", Arrays.asList(3, 4));
        courses2.put("Physics", Arrays.asList(4, 4, 4));

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", courses1));
        students.add(new Student("Jane", "Smith", courses2));

        ElectronicDiaryService service = new ElectronicDiaryService();

        Map<String, Double> averageGrades = service.getAverageGradesPerSubject(students);
        System.out.println("Средние оценки по предметам: " + averageGrades);

        Map<String, Integer> finalGrades = service.getFinalGradesForStudent(students, "John", "Doe");
        System.out.println("Итоговые оценки для John Doe: " + finalGrades);

        String hardestSubject = service.findHardestSubject(students);
        System.out.println("Самый сложный предмет: " + hardestSubject);
    }
}

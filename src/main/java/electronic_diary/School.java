package electronic_diary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class School {
    /**
     * This method takes a list of students and returns a map where the keys are the subjects
     * and the values are the average grades for each subject.
     *
     * @param students The list of students
     * @return A map with the average grades for each subject
     */
    public static Map<String, Double> averageGrades(List<Student> students) {
        Map<String, List<Integer>> totalGrades = new HashMap<>();

        for (Student student : students) {
            for (Map.Entry<String, List<Integer>> entry : student.getSubjects().entrySet()) {
                String subject = entry.getKey();
                List<Integer> grades = entry.getValue();

                totalGrades.putIfAbsent(subject, new ArrayList<>());
                totalGrades.get(subject).addAll(grades);
            }
        }

        return totalGrades.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)
                ));
    }

    /**
     * Returns a map of the final grades for the given student. The keys are the subjects
     * and the values are the average grades for each subject.
     *
     * @param students The list of students
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @return A map with the average grades for each subject
     */
    public static Map<String, Integer> finalGrades(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFullName().equals(firstName + " " + lastName)) {
                Map<String, List<Integer>> courses = student.getSubjects();
                Map<String, Integer> finalGrades = new HashMap<>();

                for (Map.Entry<String, List<Integer>> entry : courses.entrySet()) {
                    List<Integer> grades = entry.getValue();
                    int average = (int) Math.round(grades.stream().mapToInt(Integer::intValue).average().orElse(0));
                    finalGrades.put(entry.getKey(), average);
                }
                return finalGrades;
            }
        }
        return Collections.emptyMap();
    }

    /**
     * This method takes a list of students and returns the name of the subject with
     * the lowest average grade.
     *
     * @param students The list of students
     * @return The name of the subject with the lowest average grade
     *         (returns an empty string if there are no subjects)
     */
    public static String hardestSubject(List<Student> students) {
        Map<String, Double> averageGrades = averageGrades(students);
        return averageGrades.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(""); // Возвращаем пустую строку, если нет предметов
    }

    /**
     * Prints a table of students' performance. The table has columns for the
     * student's full name, average grades for each subject, percentage of the
     * average grade (relative to the maximum grade of 5), and the final grade.
     * The table is sorted by student's full name.
     *
     * @param students The list of students
     */
    public static void printPerformanceTable(List<Student> students) {
        System.out.printf("%-20s | %-12s | %-12s | %-12s | %-6s | %-12s%n", "ФИО", "Математика", "Литература", "Химия", "%", "Итоговая оценка");

        for (Student student : students) {
            String fullName = student.getFullName();
            Map<String, List<Integer>> courses = student.getSubjects();
            double totalPercentage = 0;
            double totalFinalGrade = 0;
            int countSubjects = 0;

            for (Map.Entry<String, List<Integer>> entry : courses.entrySet()) {
                List<Integer> grades = entry.getValue();
                double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0);
                double percentage = (average / 5) * 100;
                int finalGrade = (int) Math.round(average);

                System.out.printf("%-20s | %-12.2f", fullName, average);

                totalPercentage += percentage;
                totalFinalGrade += finalGrade;
                countSubjects++;
            }

            double averagePercentage = totalPercentage / countSubjects;
            double averageFinalGrade = totalFinalGrade / countSubjects;

            System.out.printf(" | %-6.2f | %-12.2f%n", averagePercentage, averageFinalGrade);
        }
    }
}

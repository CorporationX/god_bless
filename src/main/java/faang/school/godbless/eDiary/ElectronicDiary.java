package faang.school.godbless.eDiary;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class ElectronicDiary {
    private List<Student> students;

    public ElectronicDiary(List<Student> students) {
        this.students = students;
    }

    public Map<String, Double> calculateAverageGrades() {
        Map<String, Double> averageGrades = new HashMap<>();

        for (Student student : students) {
            Map<String, List<Integer>> courses = student.getCourses();
            for (String subject : courses.keySet()) {
                List<Integer> grades = courses.get(subject);
                double averageGrade = grades.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0);
                averageGrades.merge(subject, averageGrade, Double::sum);
            }
        }

        averageGrades.replaceAll((subject, sum) -> sum / students.size());
        return averageGrades;
    }

    public Map<String, Integer> calculateSubjectGrades(Student student) {
        Map<String, List<Integer>> courses = student.getCourses();
        Map<String, Integer> subjectGrades = new HashMap<>();

        for (String subject : courses.keySet()) {
            List<Integer> grades = courses.get(subject);
            double averageGrade = grades.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            int roundedGrade = (int) Math.round(averageGrade);
            subjectGrades.put(subject, roundedGrade);
        }

        return subjectGrades;
    }

    public String findMostDifficultSubject() {
        Map<String, Double> averageGrades = calculateAverageGrades();
        String mostDifficultSubject = null;
        double lowestAverageGrade = Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : averageGrades.entrySet()) {
            String subject = entry.getKey();
            double averageGrade = entry.getValue();
            if (averageGrade < lowestAverageGrade) {
                mostDifficultSubject = subject;
                lowestAverageGrade = averageGrade;
            }
        }

        return mostDifficultSubject;
    }

    public String generateTable() {
        StringBuilder header = new StringBuilder();
        header.append(String.format("%-25s", "Full name"));

        List<String> subjects = new ArrayList<>(calculateAverageGrades().keySet());
        int maxSubjectLength = getMaxSubjectLength(calculateAverageGrades());

        for (String subject : subjects) {
            header.append(String.format("| %-" + (maxSubjectLength + 2) + "s", subject));
        }

        header.append("| Grades, % | Total grade");
        header.append("\n");

        StringBuilder table = new StringBuilder();
        table.append(header);

        for (Student student : students) {
            StringBuilder row = new StringBuilder();
            row.append(String.format("%-25s", student.getFullName()));

            Map<String, List<Integer>> courses = student.getCourses();
            Map<String, Integer> subjectGrades = calculateSubjectGrades(student);
            for (String subject : subjects) {
                List<Integer> grades = courses.get(subject);
                double averageGrade = grades.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0);
                row.append(String.format("| %-" + (maxSubjectLength + 2) + ".1f", averageGrade));
            }

            double studentPercentage = calculatePercentage(courses, subjectGrades);
            row.append(String.format("| %7.1f", studentPercentage));
            row.append(String.format("| %11.1f", calculateOverallGrade(subjectGrades)));
            row.append("\n");

            table.append(row);
        }

        return table.toString();
    }

    private int getMaxSubjectLength(Map<String, Double> averageGrades) {
        int maxLength = 0;
        for (String subject : averageGrades.keySet()) {
            int subjectLength = subject.length();
            if (subjectLength > maxLength) {
                maxLength = subjectLength;
            }
        }
        return maxLength;
    }

    public double calculatePercentage(Map<String, List<Integer>> courses, Map<String, Integer> subjectGrades) {
        double totalAverage = subjectGrades.values()
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);

        double totalMaxGrade = 5.0;

        double percentage = (totalAverage / totalMaxGrade) * 100;
        return Math.min(percentage, 100);
    }

    private double calculateOverallGrade(Map<String, Integer> subjectGrades) {
        int totalGrades = subjectGrades.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        int totalSubjects = subjectGrades.size();

        return (double) totalGrades / totalSubjects;
    }
}

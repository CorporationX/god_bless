package derschrank.sprint02.task12.bjstwo_48025;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentManager implements StudentManagerInterface {
    @Override
    public Map<String, Double> getAverageGradeBySubjectThroughoutTheSchool(List<Student> students) {
        return
                students.stream()
                        .flatMap(student -> student.subjects().entrySet().stream())
                        .collect(Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.flatMapping(entry -> entry.getValue().stream(),
                                        Collectors.averagingDouble(Integer::doubleValue))));
    }

    @Override
    public Map<String, Integer> getTotalGradeByStudent(
            List<Student> students, String firstNameOfStudent, String lastNameOfStudent) {
        return Optional.of(
                getDoubleAverageGradeByStudent(students, firstNameOfStudent, lastNameOfStudent)
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (int) Math.round(entry.getValue())
                ))
        ).orElse(Map.of());
    }

    private Map<String, Double> getDoubleAverageGradeByStudent(
            List<Student> students, String firstNameOfStudent, String lastNameOfStudent) {
        return Optional.of(
                students.stream()
                        .filter(student -> firstNameOfStudent.equals(student.firstName())
                                && lastNameOfStudent.equals(student.lastName()))
                        .limit(1)
                        .map(Student::subjects)
                        .flatMap(x -> x.entrySet().stream())
                        .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        x -> (x.getValue()
                                                .stream()
                                                .mapToInt(i -> i)
                                                .average()
                                                .getAsDouble())
                                )
                        )
        ).orElse(Map.of());
    }

    @Override
    public String getMostHardSubject(List<Student> students) {
        return
                getAverageGradeBySubjectThroughoutTheSchool(students).entrySet().stream()
                        .min(Comparator.comparingDouble(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElseThrow();
    }

    @Override
    public void printTableOfStudentsWithGrade(List<Student> students) {
        Map<String, Double> averageBySchool = getAverageGradeBySubjectThroughoutTheSchool(students);
        List<String> subjects = new ArrayList<>(averageBySchool.keySet());

        final int maxSymbolsInName = getMaxSymbolsInLines(
                students.stream().map(x -> x.firstName().concat(" ").concat(x.lastName())).toList());
        final int maxSymbolsInSubject = getMaxSymbolsInLines(subjects);

        printFistLineOfTable(subjects, maxSymbolsInName, maxSymbolsInSubject);
        printOneLineOfTable("TOTAL BY SCHOOL", subjects, averageBySchool, maxSymbolsInName, maxSymbolsInSubject);
        for (Student student : students) {
            String firstName = student.firstName();
            String lastName = student.lastName();
            printOneLineOfTable(
                    firstName + " " + lastName,
                    subjects,
                    getDoubleAverageGradeByStudent(students, firstName, lastName),
                    maxSymbolsInName, maxSymbolsInSubject
            );
        }

    }

    private void printFistLineOfTable(List<String> subjects, int maxSymbolsInName, int maxSymbolsInSubject) {
        String patternForName = "%-" + maxSymbolsInName + "s|";
        System.out.format(
                patternForName, "Name"
        );

        String patternForSubject = "%" + maxSymbolsInSubject + "s|";
        for (String subject : subjects) {
            System.out.format(patternForSubject, subject);
        }
        System.out.format(
                "%10s|%10s|%n", "%", "Total"
        );

    }

    private int getMaxSymbolsInLines(List<String> strings) {
        return strings.stream().map(String::length).mapToInt(x -> x).max().getAsInt();
    }

    private void printOneLineOfTable(String title, List<String> subjects, Map<String, Double> grades,
                                     int maxSymbolsInName, int maxSymbolsInSubject) {
        String patternForName = "%-" + maxSymbolsInName + "s|";
        System.out.format(
                patternForName, title
        );
        String patternForSubject = "%" + maxSymbolsInSubject + ".2f|";
        for (String subject : subjects) {
            System.out.format(patternForSubject, grades.get(subject));
        }
        double total = getAverageGradeOfStudy(grades);
        double percent = getPercentOfStudyFromTotalGrade(total);
        System.out.format(
                "%10.2f|%10.2f|%n", percent, total
        );
    }

    private double getPercentOfStudyFromTotalGrade(double grade) {
        return grade / 5 * 100;
    }

    private double getAverageGradeOfStudy(Map<String, Double> grades) {
        return grades.values().stream().mapToDouble(x -> x).average().getAsDouble();
    }


}

package school.faang.stream2.electronicdiary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Util {
    public static void printTableInConsole(List<Student> studentList) {
        String fullNameHeader = "ФИО";
        String percentHeader = "  %  ";
        String finalResultHeader = "Итоговая оценка";
        String delimiter = " | ";

        List<String> allSubjects =
                studentList.stream()
                        .flatMap(student -> student.getCourses().keySet().stream())
                        .distinct()
                        .toList();

        int longestFullNameLength = studentList.stream()
                .mapToInt(student ->
                        student.getFirstName().length() + 1 +
                                +student.getLastName().length())
                .max()
                .orElse(fullNameHeader.length());

        String headerRow = String.join(delimiter,
                String.format("%-" + longestFullNameLength + "s", fullNameHeader),
                String.join(delimiter, allSubjects),
                percentHeader,
                finalResultHeader);

        System.out.println(headerRow);

        studentList.stream()
            .map(student -> {
                String fullName = String.join(" ", student.getFirstName(), student.getLastName());
                Map<String, Double> averageScores = allSubjects.stream().collect(Collectors.toMap(
                    subject -> subject,
                    subject -> getAverageForSubjectOnStudent(student, subject)
                ));
                Double average = averageScores.values().stream()
                    .filter(numb -> !numb.equals(0.0))
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
                return String.join(delimiter,
                    fullName + " ".repeat(longestFullNameLength - fullName.length()),
                    String.join(delimiter, allSubjects.stream()
                        .map(subj -> toTableString(averageScores.get(subj), subj.length())).toList()),
                    String.format("%.1f", average * 20.0), //percent = average / 5.0 * 100%
                    String.format("%.1f", average));
            }
        )
            .forEach(System.out::println);
    }

    private static double getAverageForSubjectOnStudent(Student student, String subject) {
        if (student.getCourses().containsKey(subject)) {
            return student.getCourses().get(subject).stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
        }
        return 0.0;
    }

    public static List<Student> parseStudentsFromFile(File file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, new TypeReference<List<Student>>() {
            });
        } catch (IOException e) {
            log.error("File parse error {}", e.getMessage());
        }
        return Collections.emptyList();
    }

    private static String toTableString(Double number, int length) {
        if (number.equals(0.0)) {
            return " ".repeat(length);
        }

        String formatted = String.format("%.1f", number);

        int totalPadding = length - formatted.length();
        int paddingLeft = totalPadding / 2;
        int paddingRight = totalPadding - paddingLeft;

        return " ".repeat(paddingLeft) + formatted + " ".repeat(paddingRight);
    }


}


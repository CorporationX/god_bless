package faang.school.godbless.streamAPI.diary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DiaryService {
    public Optional<Map<String, Integer>> getAverageMarks(List<Student> students) {
        if (students == null) {
            return Optional.empty();
        }

        var courses = students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey));

        var coursesWithAllMarks = courses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(Map.Entry::getValue)
                                .flatMap(List::stream)
                                .toList())
                );

        return Optional.of(getAverageMarks(coursesWithAllMarks));
    }

    public Optional<Map<String, Integer>> getFinalGrades(List<Student> students, String firstName, String lastName) {
        if (students == null) {
            return Optional.empty();
        }

        var targetStudent = students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst();

        if (targetStudent.isEmpty()) {
            return Optional.empty();
        }

        var studentCourses = targetStudent.get().getCourses();


        return Optional.of(getAverageMarks(studentCourses));
    }

    private Map<String, Integer> getAverageMarks(Map<String, List<Integer>> courses) {

        return courses.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            List<Integer> subjectMarks = entry.getValue();
                            var marksSum = subjectMarks.stream()
                                    .reduce(0, (total, mark) -> total += mark);

                            return Math.round((float) marksSum / subjectMarks.size());
                        })
                );
    }

    public Optional<String> getMostChallengingSubject(List<Student> students) {
        var subjectsAverageGrades = getAverageMarks(students);

        if (subjectsAverageGrades.isEmpty()) {
            return Optional.empty();
        }

        return subjectsAverageGrades.get().entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .findFirst();
    }
}

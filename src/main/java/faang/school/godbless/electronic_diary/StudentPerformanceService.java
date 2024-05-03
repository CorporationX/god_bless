package faang.school.godbless.electronic_diary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentPerformanceService {

    public Map<CourseType, Double> avgMarkForEachSubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Integer::doubleValue)
                        ))
                );
    }

    public Map<CourseType, Integer> findFinalMarksByStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(s -> s.getFirstName().equals(firstName))
                .filter(s -> s.getLastName().equals(lastName))
                .flatMap(s -> s.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.collectingAndThen(
                                        Collectors.averagingDouble(Integer::doubleValue),
                                        result -> (int) Math.round(result)
                                )
                        ))
                );
    }

    public String getHardestSubject(List<Student> students) {
        return avgMarkForEachSubject(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey()
                .name();
    }

    public void printInfoAboutEachStudent(List<Student> students) {
        students.stream().collect(StudentCollector.printInfoAboutEachStudent());
    }
}
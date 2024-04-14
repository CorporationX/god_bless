package faang.school.godbless.electronic_diary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<CourseType, List<Integer>> courses;

    public Double getAvgMarkBySubject(CourseType subject) {
        return courses.entrySet().stream()
                .filter(entry -> entry.getKey().equals(subject))
                .collect(Collectors.flatMapping(
                        entry -> entry.getValue().stream(),
                        Collectors.averagingDouble(Integer::doubleValue)
                ));
    }

}
package faang.school.godbless.ElectricDiary;

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
    private Map<Course, List<Integer>> courses;

    public Map<Course, Double> getAverageMarks() {
        return courses.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream(),
                                Collectors.averagingDouble(Double::valueOf)
                        )
                ));
    }
}

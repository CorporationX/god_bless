package school.faang.streams.electronicDiary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;
}

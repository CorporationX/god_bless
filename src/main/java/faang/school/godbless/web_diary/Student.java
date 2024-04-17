package faang.school.godbless.web_diary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;
}
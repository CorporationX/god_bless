package school.faang.electronic_devil;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> courses;
}

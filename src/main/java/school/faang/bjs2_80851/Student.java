package school.faang.bjs2_80851;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Student {
    private String firstName;
    private String lastName;
    private final Map<String, List<Integer>> courses = new HashMap<>();
}

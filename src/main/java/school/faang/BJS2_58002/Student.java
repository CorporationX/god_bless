package school.faang.BJS2_58002;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Student {
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    @NonNull
    private final Map<String, List<Integer>> courses;
}

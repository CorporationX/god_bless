package school.faang.sprint_2.task_bjs247313;


import lombok.NonNull;

import java.util.List;
import java.util.Map;

public record Student(
        @NonNull String firstName,
        @NonNull String lastName,
        Map<String, List<Integer>> subjects) {}

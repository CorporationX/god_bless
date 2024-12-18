package school.faang.sprint_2.task_bjs247301;

import lombok.NonNull;

import java.util.List;

public record UserProfile(
        int userId,
        @NonNull String gender,
        int age,
        @NonNull String location,
        @NonNull List<String> interests) {}

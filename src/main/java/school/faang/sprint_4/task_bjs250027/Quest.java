package school.faang.sprint_4.task_bjs250027;

import lombok.NonNull;

public record Quest(
        @NonNull String name,
        int difficulty,
        int reward) {
}

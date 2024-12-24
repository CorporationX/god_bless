package school.faang.sprint_4.task_bjs250835;

import lombok.NonNull;

public record Task(
        @NonNull String name,
        int difficulty,
        int reward) {
}

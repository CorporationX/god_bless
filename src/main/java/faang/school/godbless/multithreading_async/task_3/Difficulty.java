package faang.school.godbless.multithreading_async.task_3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    EASY(2000),
    MEDIUM(3000),
    HARD(6000),
    ULTRA(12000);

    private final int timeCompletion;
}

package school.faang.task_50816;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {
    TASK_DELAY_MULTIPLIER(100),
    NUM_THREADS(4),
    AWAIT_TERMINATION_TIMEOUT(10);

    private final int value;
}
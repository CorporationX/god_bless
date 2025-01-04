package school.faang.bjs250859;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {
    NUM_THREADS(5),
    FOLLOWERS_NUMBER(10),
    SUBSCRIPTION_SIMULATION_DELAY(500),
    AWAIT_TERMINATION_TIMEOUT(30);

    private final int value;
}
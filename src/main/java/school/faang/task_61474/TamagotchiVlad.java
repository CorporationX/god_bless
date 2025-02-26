package school.faang.task_61474;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;
    private State state = State.NEUTRAL;

    public synchronized void feed() {
        state = State.FULL;
        log.info("{} ест. Его состояние: {}", name, state);
    }

    public synchronized void play() {
        state = State.EXCELLENT;
        log.info("{} играет. Его состояние: {}", name, state);
    }

    public synchronized void clean() {
        state = State.CLEAN;
        log.info("{} чистится. Его состояние: {}", name, state);
    }

    public synchronized void sleep() {
        state = State.SLEEPING;
        log.info("{} спит. Его состояние: {}", name, state);
    }
}

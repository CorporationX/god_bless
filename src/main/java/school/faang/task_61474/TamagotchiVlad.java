package school.faang.task_61474;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;
    private String state = "нейтральное";

    public synchronized void feed() {
        state = "сыт";
        log.info("{} ест. Его состояние: {}", name, state);
    }

    public synchronized void play() {
        state = "весел";
        log.info("{} играет. Его состояние: {}", name, state);
    }

    public synchronized void clean() {
        state = "чист";
        log.info("{} чистится. Его состояние: {}", name, state);
    }

    public synchronized void sleep() {
        state = "спит";
        log.info("{} спит. Его состояние: {}", name, state);
    }
}

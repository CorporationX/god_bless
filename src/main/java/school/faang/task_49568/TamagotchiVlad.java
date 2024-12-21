package school.faang.task_49568;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@EqualsAndHashCode
public class TamagotchiVlad {
    private static final String DEFAULT_STATE = "нейтральное";

    private final String name;
    private String state;

    public TamagotchiVlad(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.state = DEFAULT_STATE;
    }

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

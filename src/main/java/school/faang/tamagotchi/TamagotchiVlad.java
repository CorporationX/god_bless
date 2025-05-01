package school.faang.tamagotchi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TamagotchiVlad {
    private final String name;
    private State state;

    public synchronized void feed() {
        logState(State.HUNGRY);
        state = State.FULL;
        logState();
    }

    public synchronized void play() {
        logState(State.BORED);
        state = State.HAPPY;
        logState();
    }

    public synchronized void clean() {
        logState(State.DIRTY);
        state = State.CLEAN;
        logState();
    }

    public synchronized void sleep() {
        logState(State.TIRED);
        state = State.SLEEP;
        logState();
    }

    private void logState() {
        log.info("{} теперь {}", name, state.getDescription());
    }

    private void logState(State state) {
        log.info("{} {}", name, state.getDescription());
    }
}

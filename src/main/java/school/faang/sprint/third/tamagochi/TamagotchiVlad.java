package school.faang.sprint.third.tamagochi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TamagotchiVlad {

    public synchronized void feed() {
        logState(State.FEED);
    }

    public synchronized void play() {
        logState(State.PLAY);
    }

    public synchronized void clean() {
        logState(State.CLEAN);
    }

    public synchronized void sleep() {
        logState(State.SLEEP);
    }

    private void logState(State state) {
        log.info("TamagotchiVlad now is: {}", state);
    }
}

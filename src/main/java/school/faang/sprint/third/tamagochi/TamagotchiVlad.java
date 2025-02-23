package school.faang.sprint.third.tamagochi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TamagotchiVlad {

    public synchronized void feed() {
        log.info("feed");
    }

    public synchronized void play() {
        log.info("play");
    }

    public synchronized void clean() {
        log.info("clean");
    }

    public synchronized void sleep() {
        log.info("sleep");
    }
}

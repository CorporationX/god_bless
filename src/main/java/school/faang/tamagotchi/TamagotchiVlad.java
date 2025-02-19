package school.faang.tamagotchi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class TamagotchiVlad {

    private static final int ACTING_TIME = 1000;

    private final String model;

    public synchronized void feed() {
        log.info("Влад модель {} ест", model);
        act();
        log.info("Влад модель {} доел. Теперь он сыт!", model);
    }

    public synchronized void play() {
        log.info("Влад модель {} играет", model);
        act();
        log.info("Влад модель {} доиграл. Теперь он веселый!", model);
    }

    public synchronized void clean() {
        log.info("Влад модель {} моется", model);
        act();
        log.info("Влад модель {} помылся. Теперь он чистый!", model);
    }

    public synchronized void sleep() {
        log.info("Влад модель {} спит", model);
        act();
        log.info("Влад модель {} проснулся. Теперь он полон сил и энергии!", model);
    }

    private void act() {
        try {
            Thread.sleep(ACTING_TIME);
        } catch (InterruptedException e) {
            log.error("Поток прерван во время сна, ", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

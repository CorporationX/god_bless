package faang.school.godbless.tamagotchi_vlad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@AllArgsConstructor
public class TamagotchiVlad {
    private String surname;

    public synchronized void feed() {
        log.info(surname + " was fed. He is grateful to you");
    }

    public synchronized void play() {
        log.info(surname + " started playing");
    }

    public synchronized void clean() {
        log.info(surname + " has been cleaned");
    }

    public synchronized void sleep() {
        log.info(surname + " started sleeping");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info(surname + " woke up");
    }
}

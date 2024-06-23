package faang.school.godbless.tamagotchi_vlad;

import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@AllArgsConstructor
public class TamagotchiVlad {
    private String surname;

    public synchronized void feed(){
        log.info(surname + " was fed. He is grateful to you");
    }

    public synchronized void play(){
        log.info(surname + " started playing");
    }

    public synchronized void clean() {
        log.info(surname + " has been cleaned");
    }

    @SneakyThrows
    public synchronized void sleep(){
        log.info(surname + " started sleeping");
        Thread.sleep(2000);
        log.info(surname + " woke up");
    }
}

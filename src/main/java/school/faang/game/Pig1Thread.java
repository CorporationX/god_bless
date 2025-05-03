package school.faang.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        log.info("{} начал строить дом из {}", pigName, material);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("{} закончил строительство из {} ", pigName, material);
    }
}

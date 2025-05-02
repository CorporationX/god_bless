package school.faang.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    public void run() {
        log.info("{} начал строить дом из {}", pigName, material);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("{} закончил строительство из {} ", pigName, material);
    }
}

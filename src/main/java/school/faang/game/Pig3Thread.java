package school.faang.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    public void run() {
        log.info("{} начал строить дом из {}", pigName, material);
        try {
            Thread.sleep(2000); // 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("{} закончил строительство из {} ", pigName, material);
    }
}
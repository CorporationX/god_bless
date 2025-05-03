package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
@AllArgsConstructor
class Player {
    private String name;

    public void doBattle(Boss boss) {
        log.info("{}, пытается присоединиться к битве с {}", name, boss.getBossName());
        boss.joinBattle(this);

        try {
            // Имитация боя
            log.info("{}, сражается с {}!", name, boss.getBossName());
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000) + 1000); // Имитация боя от 1 до 3 секунд
        } catch (InterruptedException e) {
            log.warn("{}, прерван во время боя с {}", name, boss.getBossName());
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
            log.info("{}, завершил бой с {}", name, boss.getBossName());
        }
    }
}
package school.faang.multithreading.sinchronized.bjs2_90270;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss("Демон ночи");

        Thread[] battleWithBoss = {
                new Thread(() -> new Player("Bill").doBattle(boss)),
                new Thread(() -> new Player("Rock").doBattle(boss)),
                new Thread(() -> new Player("Quinnn").doBattle(boss)),
                new Thread(() -> new Player("Max").doBattle(boss)),
                new Thread(() -> new Player("TOR").doBattle(boss)),
                new Thread(() -> new Player("POl").doBattle(boss)),
                new Thread(() -> new Player("Dun-Dun").doBattle(boss)),
                new Thread(() -> new Player("Bin").doBattle(boss)),
        };

        for (Thread battle : battleWithBoss) {
            battle.start();
        }

        for (Thread battle : battleWithBoss) {
            try {
                battle.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("Бой окончен.");
    }
}


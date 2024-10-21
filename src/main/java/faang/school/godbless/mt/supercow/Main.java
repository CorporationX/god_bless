package faang.school.godbless.mt.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int COMMON_TIMEOUT = 10000;

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        int battleTime = 3000;

        Player p1 = new Player("111");
        Player p2 = new Player("second");
        Player p3 = new Player("3");
        Player p4 = new Player("44");
        Player p5 = new Player("55555");

        createThread(boss, p1, battleTime).start();
        createThread(boss, p2, battleTime).start();
        createThread(boss, p3, battleTime).start();
        createThread(boss, p4, battleTime).start();
        createThread(boss, p5, battleTime).start();

        try {
            Thread.sleep(COMMON_TIMEOUT);
        } catch (InterruptedException e) {
            log.warn("Thread is interrupted");
            Thread.currentThread().interrupt();
        }

        log.info("FINISH");
    }

    private static Thread createThread(Boss boss, Player player, int battleTime) {
        return new Thread(() -> {
            try {
                player.startBattle(boss, battleTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}

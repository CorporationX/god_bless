package school.faang.bjs2_90281;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

@Slf4j
@SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
public record Player(String name) {
    private static final int BATTLE_TIME = 5;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            log.info("{} начинает бой с боссом", name);
            TimeUnit.SECONDS.sleep(BATTLE_TIME);
        } catch (InterruptedException e) {
            log.info("{} прервали в процессе боя", name);
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }

    public static void main(String[] args) {
        Boss boss = new Boss();

        Thread thread1 = new Thread(() -> new Player("CRAZY_KEVIN789").doBattle(boss));
        Thread thread2 = new Thread(() -> new Player("BubbleMaker1321").doBattle(boss));
        Thread thread3 = new Thread(() -> new Player("FreeJOE7070").doBattle(boss));
        Thread thread4 = new Thread(() -> new Player("JohnDoe__").doBattle(boss));
        Thread thread5 = new Thread(() -> new Player("Crusty").doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
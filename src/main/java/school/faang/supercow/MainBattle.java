package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainBattle {
    public static void main(String[] args) {
        Boss boss = new Boss(1, new LockerJoinBattle());
        Player firstPlayer = new Player("Gorez");
        Player secondPlayer = new Player("Geracl");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> firstPlayer.startBattle(boss));
        service.submit(() -> secondPlayer.startBattle(boss));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка при освобождении очереди боя с юоссом", e);
        }
        boss.timeOutOf();
        service.shutdown();
    }
}

package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Boss {
    private int currentPlayers = 0;

    private final Object lock = new Object();
    private final int maxPlayers = 3;
    private Player player;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers > maxPlayers  ) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + "  присоединился к сражению");
        }
    }

    public void completesBattle() {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Игрок " + player.getName() + " завершил битву");
            lock.notifyAll();
        }
    }
}

@Getter
@AllArgsConstructor
class Player {
    private String name;

    public void startBattle(Boss boss) {
        System.out.println("Сражение с боссом началось");
        boss.joinBattle(this);
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boss.completesBattle();
    }

}

class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Boss boss = new Boss();
        List<Player> players = List.of(
                new Player("Lancelot"),
                new Player("Gerald"),
                new Player("Archer"),
                new Player("Swordsman"),
                new Player("Mage")
        );
            for(Player player : players){
                executorService.submit(() -> player.startBattle(boss));
            }
            executorService.shutdown();
    }
}
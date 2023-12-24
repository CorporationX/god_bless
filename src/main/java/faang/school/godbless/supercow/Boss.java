package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Boss {
    private int currentPlayers;
    private final int maxPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (maxPlayers <= currentPlayers) {
            try {
                System.out.println(player.getName() + " В очереди на битву с боссом");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + "  присоединился к сражению! - " + Thread.currentThread().getName());
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println("Игрок " + player.getName() + " завершил битву - " + Thread.currentThread().getName());
        this.notifyAll();
    }
}

@Getter
@AllArgsConstructor
class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(this.getName() + " начал сражение с боссом");
        try {
            Thread.sleep(new Random().nextInt(1, 5) * 1_000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boss.endBattle(this);
    }
}

class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Boss boss = new Boss(4);
        List<Player> players = List.of(
                new Player("Lancelot"),
                new Player("Gerald"),
                new Player("Bars"),
                new Player("Vurdalak"),
                new Player("MagicMank"),
                new Player("Freddy"),
                new Player("Bronevik"),
                new Player("HyperSpeed"),
                new Player("Mateo")
        );

        for (Player player : players) {
            executorService.submit(() -> player.startBattle(boss));
        }
        executorService.shutdown();
    }
}
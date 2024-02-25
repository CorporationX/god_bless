package faang.school.godbless.supercow;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private List<Player> players = new ArrayList<>();
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                try {
                    System.out.printf("%s is waiting...", player.getName());
                    System.out.println();
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            currentPlayers++;
            players.add(player);
            System.out.printf("%s joins the battle!", player.getName());
            System.out.println();
        }
    }

//    public void startFight() {
//        if (!players.isEmpty()) for (Player player : players) {
//            synchronized (lock) {
//                fight(player);
//            }
//        }
//    }

    public void fight(Player player) {
        try {
            Thread.sleep(new Random().nextInt(1000, 2500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Battle for %s is over", player.getName());
        System.out.println();
        synchronized (lock) {
            currentPlayers--;
//            players.remove(player);
            lock.notify();
        }
    }
}

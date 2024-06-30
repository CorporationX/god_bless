package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Boss {
    private Object lock = new Object();
    private int maxPlayers;
    private List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        System.out.println("Hello");
    }


    public void removePlayer(Player player) {
        synchronized (lock) {
            System.out.println(player.getName()+" ended battle");
            currentPlayers.remove(player);
            lock.notifyAll();
        }
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            if (currentPlayers.size() < maxPlayers) {
                currentPlayers.add(player);
            } else {
                System.out.println("Слоты заняты ждем");
                currentPlayers.wait();
            }
        }
    }
}

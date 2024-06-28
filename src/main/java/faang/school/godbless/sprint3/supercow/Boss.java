package faang.school.godbless.sprint3.supercow;

import lombok.ToString;

import java.util.List;

@ToString
public class Boss {

    private final int maxPlayers;
    private final List<Player> currentPlayers;
    private final Object lock = new Object();

    public Boss(List<Player> currentPlayers, Integer maxPlayers) {
        this.currentPlayers = currentPlayers;
        this.maxPlayers = maxPlayers;
    }

    public void joinPlayer(Player player) {
        System.out.println("join player. " + player);
        try {
            synchronized (lock) {
                System.out.println("join player sync. " + player);
                if (currentPlayers.size() == maxPlayers) {
                    System.out.println("current players: " + currentPlayers);
                    System.out.println("wait " + player);
                    lock.wait();
                }

                System.out.println("current players: " + currentPlayers);
                currentPlayers.add(player);
            }

            startBattle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startBattle() throws InterruptedException {
        System.out.println("start battle");
        Thread.sleep(3000L);
        System.out.println("end battle");
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            System.out.println("end battle " + this);
            System.out.println("current players: " + currentPlayers);
            currentPlayers.remove(player);
            lock.notifyAll();
        }
    }

}

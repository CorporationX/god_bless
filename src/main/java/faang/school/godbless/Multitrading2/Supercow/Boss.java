package faang.school.godbless.Multitrading2.Supercow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("No more players can't fight with boos yet");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println("Players in battle " + currentPlayers);
            System.out.println(player + " join the battle");
        }
    }

    public void leaveBattle(Player player){
        synchronized (lock){
            currentPlayers--;
            System.out.println(player + " leave");
            System.out.println("Players in battle " + currentPlayers);
            lock.notify();
        }
    }
}

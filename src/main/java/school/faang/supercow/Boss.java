package school.faang.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public  void joinBattle(Player player){
        synchronized (lock){
            if (maxPlayers - currentPlayers >= 0){
                currentPlayers++;
                System.out.println("Player " + player.getName() + " has joined the battle");
            }else {
                try {
                    System.out.println("Player " + player.getName() + " has wait for the battle");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " finished the battle for the boss " + currentPlayers);
            notify();
        }
    }

}

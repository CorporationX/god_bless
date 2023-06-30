package Sprint_4_Task17;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(Thread.currentThread().getName() + " " + player.getName() + " is out of battle");
                player.wait();
            }
            currentPlayers++;
            System.out.println(Thread.currentThread().getName() + " " + "Player " +
                    player.getName() + " joined the battle " + " "+ currentPlayers);
        }
    }
    public void liftBattle(Player player) {
        synchronized (this) {
            currentPlayers--;
            System.out.println(Thread.currentThread().getName() + " " + "Player " +
                    player.getName() + " left the battle " + " "+ currentPlayers);
            notifyAll();
        }
    }
}

package Sprint_4_Task17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers > maxPlayers) {
                System.out.println(Thread.currentThread().getName() + " " + player.getName() + " is out of battle");
                player.wait();
            }
            currentPlayers++;
            System.out.println(Thread.currentThread().getName() + " " + "Player " + player.getName() + " joined the battle");
        }
        synchronized (this) {
            currentPlayers--;
            System.out.println(Thread.currentThread().getName() + " " + "Player " + player.getName() + " left the battle");
            notify();
        }
    }
}

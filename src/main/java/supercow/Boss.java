package supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }
    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            currentPlayers++;
            System.out.println(player.getName() + " присоединился к игре с боссом");
        } else {
            try {
                System.out.println(player.getName() + " ожидает свою очередь");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void endBattle(Player player) {
        System.out.println(player.getName() + " игру с боссом закончил");
        currentPlayers--;
        notifyAll();
    }
}

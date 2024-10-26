package supercow;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ожидает свободного слота для сражения с боссом.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Что-то пошло не так при вызове метода wait().");
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению с боссом.");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершает сражение с боссом.");
        notify();
    }
}

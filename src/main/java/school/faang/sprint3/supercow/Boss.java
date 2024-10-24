package school.faang.sprint3.supercow;

import lombok.Getter;

@Getter
public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + "Ждет свободный слот");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentPlayers++;
            System.out.println(player.getName() + " присайдинился к баю");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + "завершил сражение с боссом!");
        notify();
    }
}

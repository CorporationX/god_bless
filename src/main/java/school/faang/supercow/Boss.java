package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                System.out.println("Сейчас с боссом сражается максимальное кол-во игроков.");
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
        currentPlayers++;
        System.out.println("Игрок " + player.getName() + " приступает к сражению с боссом.");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Игрок " + player.getName() + " покидает битву.");
        this.notify();
    }
}

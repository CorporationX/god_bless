package faang.school.godbless.sprint_3.supercow;

import lombok.Data;

@Data
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.printf("Player with name '%s' waiting!\n", player.getName());
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        currentPlayers++;
        System.out.printf("Player with name '%s' was joined!\n", player.getName());
    }

    public synchronized void finishGame() {
        currentPlayers--;
        notify();
    }
}
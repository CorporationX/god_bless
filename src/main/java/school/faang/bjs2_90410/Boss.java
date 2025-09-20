package school.faang.bjs2_90410;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers == maxPlayers) {
            System.out.printf("Игрок %s ожидает присоединения к бою%n", player.getName());
            this.wait();
        }
        currentPlayers++;
        System.out.printf("Игрок %s присоединился к бою%n", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("Игрок %s вышел из боя%n", player.getName());
        this.notify();
    }
}

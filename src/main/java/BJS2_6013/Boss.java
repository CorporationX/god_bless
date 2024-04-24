package BJS2_6013;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private final int MAX_PLAYERS;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= MAX_PLAYERS) {
            try {
                wait();
            } catch (InterruptedException ex) {
                throw new RuntimeException();
            }
        }
        currentPlayers++;
        System.out.println("К сражению присоединился новый игрок " + player.getName());
    }

    public synchronized void finishBattle(Player player) {
        currentPlayers--;
        System.out.println("Завершил сражение " + player.getName());
        notify();
    }
}

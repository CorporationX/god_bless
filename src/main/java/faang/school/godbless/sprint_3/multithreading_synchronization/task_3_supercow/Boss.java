package faang.school.godbless.sprint_3.multithreading_synchronization.task_3_supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final List<Player> playerList = new ArrayList<>();
    public static final String MSG_PLAYER_JOIN = "Игрок %s присоединился к сражению.";
    public static final String MSG_PLAYER_ABSENT = "Игрока %s нет в сражении.";
    public static final String MSG_PLAYER_ESCAPE = "Игрок %s покинул сражение.";
    private final int maxPlayers;

    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (playerList) {
            if (currentPlayers >= maxPlayers) {
                playerList.wait();
            }
            playerList.add(player);
            currentPlayers++;
            System.out.printf((MSG_PLAYER_JOIN) + "%n", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (playerList) {
            if (playerList.contains(player)) {
                playerList.remove(player);
                currentPlayers--;
                System.out.printf((MSG_PLAYER_ESCAPE) + "%n", player.name());
                playerList.notify();
            } else {
                System.out.printf((MSG_PLAYER_ABSENT) + "%n", player.name());
            }
        }
    }
}

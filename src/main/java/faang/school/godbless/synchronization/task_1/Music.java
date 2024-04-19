package faang.school.godbless.synchronization.task_1;

import faang.school.godbless.synchronization.task_1.model.Player;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> playerOperations = getPlayerOperations(player);
        for (Thread playerOperation : playerOperations) {
            playerOperation.start();
        }

    }

    public static List<Thread> getPlayerOperations(Player player) {
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(() -> {
            try {
                player.pause();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);
        return List.of(playThread, pauseThread, skipThread, previousThread);
    }
}

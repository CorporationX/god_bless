package school.faang.bjs2_37212;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Game {
    private final static int POOL_SIZE = 5;

    private final List<Npc> npcList;
    private final Player player;
    private ExecutorService executor;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Object cycleLock = new Object();

    public Game(List<Npc> npcList, Player player) {
        this.player = player;
        this.npcList = npcList;
    }


    public void fight() {
        executor = Executors.newFixedThreadPool(POOL_SIZE);

        log.info("Battle is begins!");

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(this::battle);
        }
    }

    private void battle() {
        for (Npc npc : npcList) {
            if (player.getStrength() > npc.getStrength()) {
                synchronized (scoreLock) {
                    if (isDead()) {
                        gameOver();
                    } else {
                        updateScore();
                    }
                }
            } else {
                synchronized (livesLock) {
                    if (isDead()) {
                        gameOver();
                    } else {
                        updateLives();
                    }
                }
            }
        }
    }

    private void updateScore() {
        player.setScore(player.getScore() + 1);
        log.info(String.format("For player '%s' increased number of points. Total score: %s", player.getName(), player.getScore()));
    }

    private void updateLives() {
        player.setLives(player.getLives() - 1);
        log.info(String.format("Player '%s' lost :( Lives left : %s", player.getName(), player.getLives()));

    }

    public boolean isDead() {
        return player.getLives() <= 0;
    }

    private void gameOver() {
        executor.shutdown();
    }
}

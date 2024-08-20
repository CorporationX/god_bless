package faang.school.godbless.task.multithreading.bro.force;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private long score = 0;
    private long lives = 0;

    public void update(Player player) {
        if (player.battleSuccessful()) {
            handleSuccessfulBattle(player);
        } else {
            handleUnsuccessfulBattle(player);
        }
        log.info("Общий счет игры, очков: {}, смертей: {}", score, lives);
    }

    private void handleSuccessfulBattle(Player player) {
        synchronized (scoreLock) {
            player.incrementScore();
            score++;
        }
        log.info("Игрок {} победил в схватке и получает одно очко", player.getName());
    }

    private void handleUnsuccessfulBattle(Player player) {
        if (player.getLives() > 1) {
            player.decrementLive();
            log.info("Игрок {} проиграл в схватке и потерял одну жизнь", player.getName());
        } else {
            gameOver(player);
        }
    }

    private void gameOver(Player player) {
        synchronized (livesLock) {
            player.decrementLive();
            lives++;
        }
        if (!player.isAlive()) {
            log.info("Игрок {} проиграл в битве и потратил последнюю жизнь", player.getName());
            log.info("Игрок {} умер =(", player.getName());
        }
    }
}

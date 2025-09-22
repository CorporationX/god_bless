package school.faang.bjs2_92300;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    @Getter private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreUp, boolean isLiveLost, Player player) {
        if (!player.isGameOver()) {
            if (isScoreUp) {
                synchronized (scoreLock) {
                    player.setScore(player.getScore() + 1);
                    log.info("Счет игрока {} увеличен на 1 и равен {}", player.getName(), player.getScore());
                    score++;
                    log.info("Общий счет в игре увеличен на 1 и равен {}", score);
                }
            }
            if (isLiveLost) {
                synchronized (livesLock) {
                    player.setLives(player.getLives() - 1);
                    log.info("Игрок {} потерял 1 жизнь, осталось: {}", player.getName(), player.getLives());
                    lives++;
                    log.info("Общее число потерянных жизней в игре увеличено на 1 и равно {}", lives);
                    if (player.getLives() == 0) {
                        gameOver(player);
                    }
                }
            }
        }
    }

    private void gameOver(Player player) {
        player.setGameOver(true);
        log.info("Игрок {} потерял все жизни. {} проиграл!", player.getName(), player.getName());
    }
}

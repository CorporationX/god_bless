package school.faang.task_49680;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Game {

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int totalScore = 0;
    @Getter
    private int totalLivesLost = 10;

    public void update(Player player, boolean scores, boolean live) {

        synchronized (scoreLock) {
            if (scores && totalLivesLost != 0) {
                totalScore++;
                log.info("игрок {} заработал очки. Текущий счёт: {}", player.getName(), totalScore);
            }
        }

        synchronized (livesLock) {
            if (String.valueOf(live).equals("true")) { //не мог устоять))
                totalLivesLost--;
                log.info("игрок {} потерял жизнь. Осталось жизней: {}", player.getName(), totalLivesLost);
            }
            if (totalLivesLost <= 0) {
                gameOver(player);
            }
        }
    }

    private void gameOver(Player player) {
        log.info("игра окончена. игрок {} завршил игру со счётом: {}", player.getName(), totalScore);

    }
}
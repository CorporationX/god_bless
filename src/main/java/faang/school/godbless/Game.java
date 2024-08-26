package faang.school.godbless;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Game {
    private int score = 0;
    private int lives = 10;

    Object scoreLock = new Object();
    Object livesLock = new Object();

    public void update(boolean playerLostLife, Player player) {
        if (playerLostLife) {
            synchronized (livesLock) {
                if (lives > 0) {
                    lives--;
                    log.info("" + player.getName() + " lost life, remaining " + lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }else {
            synchronized (scoreLock){
                score++;
                log.info("" + player.getName() + " - score increased ");
            }
        }
    }

    public void gameOver() {
        log.info("game over");
    }
}

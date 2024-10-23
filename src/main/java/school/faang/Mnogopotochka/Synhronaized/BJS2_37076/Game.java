package school.faang.Mnogopotochka.Synhronaized.BJS2_37076;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private int score = 0;
    private int lives = 10;

    public void update(Player player, boolean event){
        if(event) {
            synchronized (lock1) {
                score++;
                log.info("Iгрок: {} заработал 1 очко, общее число {}",player.getName(), score);
                if(score >= 10){
                    gameWin(player);
                }
            }
        } else {
            synchronized (lock2) {
                lives--;
                log.info("Iгрок: {} потерял 1 очко здоровья , общее число {}",player.getName(), lives);
                if(lives <= 0){
                    gameOver(player);
                }
            }
        }
    }

    private void gameWin(Player player){
        log.info("Iгрок: {} выиграл со счетом: {}", player.getName(), score);
    }

    private void gameOver(Player player){
        log.info("Iгрок: {} проиграл со счетом: {}", player.getName(), score);
    }
}

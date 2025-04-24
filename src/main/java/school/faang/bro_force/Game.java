package school.faang.bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    @Getter
    private final List<Bro> bros;

    public Game(List<Bro> bros) {
        this.bros = bros;
    }

    public void update(boolean isAddPoints, boolean isLifeMinus, Bro bro) {
        if (isAddPoints) {
            synchronized (scoreLock) {
                score++;
                log.info("Получили очко. Ваш счет: {}", score);
            }
        }

        if (isLifeMinus) {
            synchronized (livesLock) {
                lives++;
                bro.setLives(bro.getLives() - 1);
                log.info("Вы {} потерляи жизнь. Текущее колличество жизней: {}", bro.getName(), bro.getLives());
                if (bro.getLives() == 0) {
                    gameOver(bro);
                }
            }
        }
    }

    private void gameOver(Bro bro) {
        log.info("Вы, {}, проиграли", bro.getName());
        bro.setAlive(false);
        log.info("Общее колличество очков: {}", score);
        log.info("Жизней ыло потеряно: {}", lives);
    }

    public boolean isSomeoneAlive() {
        return bros.stream().allMatch(Bro::isAlive);
    }

}

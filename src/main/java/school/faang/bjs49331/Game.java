package school.faang.bjs49331;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

@Slf4j
public class Game {
    private final Object scoreLock;
    private final Object livesLock;
    private final Object gameOverLock;
    @Getter
    private int score;
    @Getter
    private int lives;
    @Getter
    private volatile boolean gameOver;
    private final AtomicInteger playersLeft;
    private final List<Bro> bros;

    public Game(List<Bro> bros) {
        scoreLock = new Object();
        livesLock = new Object();
        gameOverLock = new Object();
        score = 0;
        gameOver = false;
        this.bros = bros;
        playersLeft = new AtomicInteger(bros.size());
    }

    public void update(BiConsumer<Bro, Bro> attackAction, int attackingBroIndex, int receivingBroIndex) {
        Bro attackingBro;
        Bro receivingBro;
        synchronized (bros) {
            if (attackingBroIndex == receivingBroIndex) {
                return;
            }
            attackingBro = bros.get(attackingBroIndex % bros.size());
            receivingBro = bros.get(receivingBroIndex % bros.size());

            bros.remove(attackingBro);
            bros.remove(receivingBro);
        }
        attackAction.accept(attackingBro, receivingBro);
        processResults(attackingBro);
        processResults(receivingBro);

        synchronized (scoreLock) {
            score++;
        }
        synchronized (livesLock) {
            lives--;
        }
        synchronized (gameOverLock) {
            if (playersLeft.get() == 1 && !gameOver) {
                Bro winner = bros.get(0);
                log.info("Winner is {} with score {}", winner.getName(), winner.getScore());
                gameOver = true;
            }
        }
    }

    public int getPlayersLeft() {
        return playersLeft.get();
    }

    public int getTotalPlayers() {
        return bros.size();
    }

    private void processResults(Bro bro) {
        if (!bro.isEliminated()) {
            synchronized (bros) {
                bros.add(bro);
            }
        } else {
            playersLeft.decrementAndGet();
        }
    }
}

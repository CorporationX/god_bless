package faang.school.godbless.BJS2_13089;

import lombok.Getter;

import java.util.List;

public class Game {
    private int score = 0;
    private int lives = 0;
    @Getter
    private final List<Player> players;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() throws InterruptedException {
        players.forEach(player -> {
            try {
                player.makeAttack(this);
                increaseScores();
                increaseLives();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void gameOver() {
        System.out.println("Game over");
        System.out.println("Total score: " + score);
        System.out.println("Total lives: " + lives);
    }


    public boolean isAllAlive() {
        return players.stream()
                .allMatch(Player::isAlive);
    }

    public void increaseScores() {
        synchronized (scoreLock) {
            score += 1;
            scoreLock.notifyAll();
        }
    }

    public void increaseLives() {
        synchronized (livesLock) {
            lives += 1;
            livesLock.notifyAll();
        }
    }
}

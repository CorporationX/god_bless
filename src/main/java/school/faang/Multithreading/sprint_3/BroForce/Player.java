package school.faang.Multithreading.sprint_3.BroForce;

import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private boolean isLife = true;
    private int scorePlayer = 0;

    public Player(String name) {
        this.name = name;
    }

    public void earnScorePlayer(Game game) {
        synchronized (game.getLockScore()) {
            scorePlayer++;
            System.out.println("Игрок " + name + " заработал очки: " + scorePlayer);
            game.getLockScore().notify();
        }
    }

    public void diePlayer(Game game) {
        synchronized (game.getLockLives()) {
            isLife = false;
            game.getLockLives().notify();
        }
    }

    public boolean hasScorePlayer() {
        return scorePlayer != 0;
    }

    public boolean isDiePlayer() {
        return !isLife;
    }
}

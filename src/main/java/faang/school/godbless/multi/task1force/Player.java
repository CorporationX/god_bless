package faang.school.godbless.multi.task1force;

import lombok.Getter;

@Getter
public class Player implements Runnable {
    private int score = 0;
    private int lives;
    private final Game game;
    private final String name;

    public Player(Game game, String name, int lives) {
        this.game = game;
        this.name = name;
        this.lives = lives;
    }

    @Override
    public void run() {
        while (lives > 0) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
                boolean isLifeLost = Math.random() < 0.2;
                boolean isScore = Math.random() < 0.5;
                game.update(isScore, isLifeLost, this);
            } catch (InterruptedException e) {
                System.out.println("Соединение разорвано");
            }
        }
        game.checkGameOver();
    }

    public synchronized void updateScore() {
        score++;
        System.out.println(name + " заработал очко. Очки: " + score);
    }

    public synchronized void loseLife() {
        lives--;
        System.out.println(name + " потерял жизнь. Жизни: " + lives);
    }

    public boolean isAlive() {
        return lives > 0;
    }
}

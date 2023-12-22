package BroForce;

import lombok.Getter;

@Getter
public class Player extends Thread {
    Game game;
    int lives = 3;
    ScoreUpdater scoreUpdater = new ScoreUpdater();
    LivesUpdater livesUpdater = new LivesUpdater();

    public Player(Game game) {
        this.game = game;
    }

    public void update() {
        int lostLives = countLostLives();
        lives -= lostLives;
        livesUpdater.setLives(lostLives);
        scoreUpdater.setScore((int) (Math.random() * 10));
        game.update(this);
    }

    //Случайно выбираем вычитать жизнь или нет
    public int countLostLives() {
        double random = Math.random();
        if (random >= 0.5) {
            return 1;
        } else {
            return 0;
        }
    }

    public void run() {
        while (true) {
            //Если кто-то умер - прекращаем цикл
            if (game.isDead()) {
                break;
            }
            update();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

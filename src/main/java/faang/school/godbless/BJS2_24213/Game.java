package faang.school.godbless.BJS2_24213;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int score;
    private int lives;
    private final Object lock = new Object();
    private List<GameObject> gameObjects = new ArrayList<>();

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void update(GameObject gameObject) {
        if (gameObject.isAlive()) {
            synchronized (lock) {
                gameObject.setScore(gameObject.getScore() + 1);
                score++;
            }
        } else {
            synchronized (lock) {
                gameObject.setLives(gameObject.getLives() - 1);
                lives++;
                System.out.println(gameObject.getName() + " with lives: " + gameObject.getLives());
            }
            if (gameObject.getLives() == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over");
    }
}

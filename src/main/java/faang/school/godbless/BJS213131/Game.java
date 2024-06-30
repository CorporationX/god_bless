package faang.school.godbless.BJS213131;

import lombok.Getter;

import java.util.List;
import java.util.Random;

public class Game {
    @Getter
    private boolean isActive;

    public List<Gamer> createGamers() {
        isActive = true;
        return List.of(
                new Gamer("Rambro"),
                new Gamer("Indiana Brones"),
                new Gamer("Brade"),
                new Gamer("Bro Dredd")
        );
    }


    public void update(Gamer gamer) {
        Random randomAction = new Random();
        while (isActive) {
            if (randomAction.nextInt(2) == 1) {
                gamer.killEnemy();
            } else if (!gamer.isGameContinueAfterDeath()) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        synchronized (Gamer.class) {
            isActive = false;
        }
    }
}

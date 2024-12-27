package school.faang.bjs249349;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Game {
    private int score;
    private int lives;

    public void update() {
        score++;
        lives--;

        if (lives < 1) {
            gameOver();
        }
    }

    private void gameOver() {

    }
}

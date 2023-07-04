package faang.school.godbless.BroForce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bro {
    private String name;
    private int lives;
    private int score;

    public void decrementLives() {
        lives--;
    }

    public void incrementScore() {
        score++;
    }
}

package faang.school.godbless.BroForce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bro {
    private String name;
    private int lives;

    public void decreaseLives() {
        lives--;
    }

    public boolean isAlive() {
        return lives > 0;
    }
}

package faang.school.godbless.dolbahlop.multithreading.synchronization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int lives;

    public synchronized boolean isAlive() {
        return lives > 0;
    }
    public synchronized void loseLife() {
        lives--;
    }
}

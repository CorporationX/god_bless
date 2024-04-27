package faang.school.godbless.Task_26;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game {

    static final Object LOCKFORSCORE = new Object();
    static Object getLockforscore = new Object();

    int score;
    int lives;

    void update() {
        synchronized (LOCKFORSCORE) {
            score++;
        }
        synchronized (getLockforscore) {
            lives++;
        }
    }

    private void gameOver() {
        System.out.println("Game over");
    }
}

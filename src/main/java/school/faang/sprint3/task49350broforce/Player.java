package school.faang.sprint3.task49350broforce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int score;
    private int lives;


    Player(String name) {
        this.name = name;
        this.score = 0;
        this.lives = 10;
    }

    Player(String name, int lives) {
        this.name = name;
        this.score = 0;
        this.lives = lives;
    }

    public synchronized void earnPoints() {
        score++;
        System.out.printf("%s заработал очки %n", this.name);
    }

    public synchronized void loseLives() {
        lives--;
        System.out.printf("%s потерял HP %n", this.name);
    }
}

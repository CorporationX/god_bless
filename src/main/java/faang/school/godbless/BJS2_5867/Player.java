package faang.school.godbless.BJS2_5867;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private boolean alive;
    private int score;
    private int currentScore;

    public void earnScore() {
        if (this.alive) {
            this.score += 1;
            this.currentScore += 1;
            System.out.println(name + " earn 1 score");
        } else {
            System.out.println("Player is died!");
        }
    }

    public void killPlayer() {
        this.alive = false;
        System.out.println(name + " is died");
    }
}

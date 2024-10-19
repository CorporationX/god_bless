package school.faang.thirdStream.BJS2_37117;

import lombok.Data;

@Data
public class Player {
    private final String name;
    private int lives;
    private int score;

    public Player(String name) {
        this.name = name;
        lives = 5;
        score = 0;
    }
}

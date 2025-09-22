package school.faang.bjs2_92300;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    @Setter private int score = 0;
    @Setter private int lives = 2;
    @Setter private boolean isGameOver = false;

    public Player(String name) {
        this.name = name;
    }
}

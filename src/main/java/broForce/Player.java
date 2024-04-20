package broForce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Player {
    private String name;
    private int lives;

    public Player(String name) {
        this.name = name;
        this.lives = 100;
    }
}

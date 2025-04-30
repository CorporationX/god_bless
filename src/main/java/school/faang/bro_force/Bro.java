package school.faang.bro_force;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {

    private String name;
    private int lives;
    private int score = 0;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}

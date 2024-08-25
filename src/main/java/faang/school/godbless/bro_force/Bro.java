package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {
    private final String name;
    private int lives;
    private boolean isDied;

    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
}

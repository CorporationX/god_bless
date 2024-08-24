package faang.school.godbless.javasynchronized.task4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bro {
    public Bro(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    private String name;
    private int lives;

    public void getDamage() {
        lives--;
    }
}

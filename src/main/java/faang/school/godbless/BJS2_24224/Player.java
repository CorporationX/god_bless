package faang.school.godbless.BJS2_24224;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private int lives;

    public void playerDead() {
        lives--;
        System.out.println("Player " + name + " is dead, remained - " + lives + " lives");
    }
}

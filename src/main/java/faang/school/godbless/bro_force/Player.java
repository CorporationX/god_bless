package faang.school.godbless.bro_force;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    @Setter
    private boolean isAlive;

    public Player(String name) {
        this.name = name;
        isAlive = true;
    }
}

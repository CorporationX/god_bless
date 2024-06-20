package faang.school.godbless.bro_force;

import lombok.Data;

@Data
public class Player {
    private String name;
    private boolean isAlive;

    public Player(String name) {
        this.name = name;
        isAlive = true;
    }
}

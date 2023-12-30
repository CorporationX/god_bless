package faang.school.godbless.BroForce;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final String name;
    private int live;
    private boolean alive = true;
    private int score = 0;

    public Player(String name, int live) {
        this.name = name;
        this.live = live;
    }
}



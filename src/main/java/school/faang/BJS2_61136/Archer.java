package school.faang.BJS2_61136;

import lombok.Getter;

@Getter
public class Archer extends Warrior {

    private static final int POWER = 25;

    public Archer() {
        super(POWER);
    }
}

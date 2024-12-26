package school.faang.task_48486;

import lombok.Getter;

@Getter
public class Mage extends Character {
    private static final int MAGE_POWER = 50;

    public Mage() {
        super(MAGE_POWER);
    }
}

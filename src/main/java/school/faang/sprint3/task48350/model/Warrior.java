package school.faang.sprint3.task48350.model;


import lombok.Getter;

@Getter
public class Warrior {

    protected static final int ARCHER_POWER = 40;
    protected static final int SWORDSMAN_POWER = 50;
    protected static final int MAGE_POWER = 60;
    protected static final int KNIGHT_POWER = 80;

    protected int power;
    protected String type;
}

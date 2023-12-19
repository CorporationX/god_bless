package heroArmy_1003;

import lombok.Data;

public class Mage extends Unit{
    private int power;

    public Mage(int power) {
        super(power, "Mage");
    }
}
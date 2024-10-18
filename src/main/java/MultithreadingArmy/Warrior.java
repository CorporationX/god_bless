package MultithreadingArmy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior {
    private int power;

    public boolean isArcher() {
        return this.getClass() == Archer.class;
    }

    public boolean isMage() {
        return this.getClass() == Mage.class;
    }

    public boolean isSwordsman() {
        return this.getClass() == Swordsman.class;
    }
}

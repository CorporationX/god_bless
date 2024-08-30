package faang.school.godbless.DistributedArmy;

import lombok.Getter;

@Getter
public class Mage extends ArmyUnit {
    public Mage() {
        super(3);
    }

    public Mage(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Mage";
    }
}

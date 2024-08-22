package faang.school.godbless.DistributedArmy;

import lombok.Getter;

@Getter
public class Archer extends ArmyUnit {
    public Archer() {
        super(1);
    }

    public Archer(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Archer";
    }
}

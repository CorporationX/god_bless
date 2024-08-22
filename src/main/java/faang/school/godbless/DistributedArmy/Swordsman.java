package faang.school.godbless.DistributedArmy;

import lombok.Getter;

@Getter
public class Swordsman extends ArmyUnit {
    public Swordsman() {
        super(2);
    }

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "Swordsman";
    }
}

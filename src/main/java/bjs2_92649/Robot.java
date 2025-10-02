package bjs2_92649;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Robot {
    private final String name;
    private final int attackPower;
    private final int defensePower;

    public int getTotalPower() {
        return attackPower + defensePower;
    }

    @Override
    public String toString() {
        return name + " [Атака=" + attackPower + ", Защита=" + defensePower + "]";
    }
}
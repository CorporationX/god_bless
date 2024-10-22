package school.BJS2_38303;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot implements Comparable<Robot> {

    private String name;
    private int attackPower;
    private int defensePower;

    public int sumOfAttackAndPower() {
        return attackPower + defensePower;
    }

    @Override
    public int compareTo(Robot o) {
        return this.sumOfAttackAndPower() - o.sumOfAttackAndPower();
    }
}

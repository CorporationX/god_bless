package faang.school.godbless.BJS2_14095;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot implements Comparable<Robot> {
    private String name;
    private int attackPower;
    private int defensePower;

    @Override
    public int compareTo(Robot o) {
        return (this.attackPower - o.getDefensePower()) - (o.getAttackPower() - this.getDefensePower());
    }
}

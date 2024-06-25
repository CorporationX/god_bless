package faang.school.godbless.star_wars_arena;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot implements Comparable<Robot> {
    private String name;
    private int attackPower;
    private int defencePower;

    @Override
    public int compareTo(Robot o) {
        int attackComparison = Integer.compare(attackPower, o.getAttackPower());
        if (attackComparison != 0) {
            return attackComparison;
        }

        int defenceComparison = Integer.compare(defencePower, o.getDefencePower());
        if (defenceComparison == 0) {
            return 1;
        }
        return defenceComparison;
    }
}

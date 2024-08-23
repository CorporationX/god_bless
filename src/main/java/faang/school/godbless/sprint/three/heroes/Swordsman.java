package faang.school.godbless.sprint.three.heroes;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Swordsman extends Unit {
    private final String name = "Swordsman";
    public Swordsman(int power) {
        super(power);
    }
}

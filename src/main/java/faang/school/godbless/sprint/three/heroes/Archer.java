package faang.school.godbless.sprint.three.heroes;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Archer extends Unit {
    private final String name = "Archer";
    public Archer(int power) {
        super(power);
    }
}

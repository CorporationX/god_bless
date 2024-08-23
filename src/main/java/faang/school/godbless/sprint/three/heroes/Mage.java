package faang.school.godbless.sprint.three.heroes;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Mage extends Unit {
    private final String name = "Mage";
    public Mage(int power) {
        super(power);
    }
}

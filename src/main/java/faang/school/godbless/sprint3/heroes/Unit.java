package faang.school.godbless.sprint3.heroes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Unit {
    protected int power;

    public int getPower() {
        return power;
    }
}

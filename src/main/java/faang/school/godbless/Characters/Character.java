package faang.school.godbless.Characters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Character {
    protected String name;
    protected int power;

    public synchronized int getPower() {
        return power;
    }
}

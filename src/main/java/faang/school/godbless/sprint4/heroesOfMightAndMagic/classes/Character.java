package faang.school.godbless.sprint4.heroesOfMightAndMagic.classes;

import lombok.Getter;

@Getter
public abstract class Character {
    private final int power;
    private final String name;

    protected Character(int power, String name) {
        this.power = power;
        this.name = name;
    }
}

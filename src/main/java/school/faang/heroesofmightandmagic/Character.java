package school.faang.heroesofmightandmagic;

import lombok.Getter;

@Getter
public abstract class Character {
    private final int power;

    public Character(int power) {
        this.power = power;
    }
}

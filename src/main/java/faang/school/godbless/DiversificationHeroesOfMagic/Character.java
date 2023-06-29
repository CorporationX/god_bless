package faang.school.godbless.DiversificationHeroesOfMagic;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Character {
    private int power;

    public Character(int power) {
        this.power = power;
    }
}

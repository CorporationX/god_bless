package school.faang.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior {

    private int power;

    public Warrior(int power) {
        this.power = power;
    }
}

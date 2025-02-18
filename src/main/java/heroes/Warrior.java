package heroes;

import lombok.Getter;

@Getter
public class Warrior {
    protected int power;

    public Warrior(int power) {
        this.power = power;
    }
}

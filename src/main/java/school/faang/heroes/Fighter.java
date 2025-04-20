package school.faang.heroes;

import lombok.Data;

@Data
public abstract class Fighter {
    private int power;

    public Fighter(int power) {
        this.power = power;
    }
}

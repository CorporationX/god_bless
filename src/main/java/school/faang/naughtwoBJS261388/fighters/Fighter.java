package school.faang.naughtwoBJS261388.fighters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public abstract class Fighter {

    private String name;
    @Setter
    private int power;
    private int health = 100;

    public Fighter(int power) {
        this.power = power;
    }

    public Fighter(@NonNull String name, int power) {
        this.name = name;
        this.power = power;
    }
}

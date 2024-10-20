package school.faang.Fighter;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Fighter {
    private int power;

    public Fighter(int power) {
        this.power = power;
    }
}

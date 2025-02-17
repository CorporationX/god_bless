package school.faang.sprint3.BJS2_61144.fighters;

import lombok.Getter;

@Getter
public class Fighter {
    private final int power;

    protected Fighter(int power) {
        this.power = power;
    }
}

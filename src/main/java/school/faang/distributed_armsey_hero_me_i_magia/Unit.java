package school.faang.distributed_armsey_hero_me_i_magia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Unit {
    protected int power;

    protected void setPower(int power) {
        this.power = power;
    }
}

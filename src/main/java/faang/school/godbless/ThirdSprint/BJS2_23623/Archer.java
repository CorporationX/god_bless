package faang.school.godbless.ThirdSprint.BJS2_23623;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class Archer extends Unit {
    private static AtomicInteger totalPower = new AtomicInteger(0);
    private int power;

    public Archer(int power) {
        this.power = power;
    }

    public int totalPowerIncrement(int delta) {
        return totalPower.addAndGet(delta);
    }

    public int getTotalPower() {
        return totalPower.get();
    }
}

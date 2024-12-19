package school.faang.sprint_1.task_armyofheroesbjs2n47795;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Getter
public class PowerCalculator<T extends Warrior> implements Runnable {
    private List<T> warriors;
    private int sum;

    public PowerCalculator(List<T> warriors) {
        this.warriors = warriors;
        this.sum = 0;
    }

    @Override
    public void run() {
        this.sum = calculatePower();
    }

    public int calculatePower() {
        int sum = 0;
        for (T warrior : warriors) {
            sum += warrior.getPower();
            log.info("{} power calculation", warrior.getClass().getSimpleName());
        }
        return sum;
    }
}

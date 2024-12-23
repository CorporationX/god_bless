package school.faang.task_48466;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerCalculator extends Thread {
    private final Unit unit;
    @Getter
    private int result;

    public PowerCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        int unitPower = unit.getPower();
        log.info("Unit power = {}", unitPower);
        result = unitPower;
    }
}

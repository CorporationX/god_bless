package faang.school.godbless.hmmarmy;

import faang.school.godbless.hmmarmy.characters.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorThread extends Thread {
    private final Unit unit;
    private int power = 0;

    public CalculatorThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        setPower(unit.getPower());
    }
}

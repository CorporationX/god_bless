package school.faang.task_47815;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UnitThread extends Thread {
    private final Unit unit;
    @Getter
    private int power;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}

package school.faang.sprint3.task_47805;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UnitThread extends Thread {
    private final Character unit;
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }
}

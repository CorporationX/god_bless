package school.faang.task_47897;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PowerCounter extends Thread {
    private final Unit unit;
    private int currentPower;

    @Override
    public void run() {
        this.currentPower = unit.getPower();
    }
}

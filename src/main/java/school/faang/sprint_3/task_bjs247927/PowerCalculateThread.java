package school.faang.sprint_3.task_bjs247927;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PowerCalculateThread extends Thread {
    @NonNull
    private final Unit unit;
    private int power;

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}

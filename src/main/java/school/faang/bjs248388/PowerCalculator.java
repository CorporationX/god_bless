package school.faang.bjs248388;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PowerCalculator implements Runnable {
    @NonNull
    private final Unit unit;
    @Getter
    private int power;

    @Override
    public void run() {
        this.power = unit.getPower();
    }
}

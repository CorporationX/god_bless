package faang.school.godbless.hommArmy.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PowerUnit extends Thread {

    private final Unit unit;
    private int power;

    @Override
    public void run() {
        power = unit.getPower();
    }
}

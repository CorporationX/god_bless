package faang.school.godbless.sprint4_multithreading.army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Getter
public class PowerThread extends Thread{
    private final Unit unit;
    private int unitPower;

    @Override
    public void run() {
        unitPower = unit.getPower();
    }




}

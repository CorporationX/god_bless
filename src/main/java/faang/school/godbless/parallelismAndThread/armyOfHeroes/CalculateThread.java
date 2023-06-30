package faang.school.godbless.parallelismAndThread.armyOfHeroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class CalculateThread extends Thread {
    private int power;
    @NonNull
    @Setter
    private Unit unit;

    @Override
    public void run() {
        sumPowerOfUnit();
    }

    public void sumPowerOfUnit() {
        power += unit.getPower();
    }
}

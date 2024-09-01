package BJS2_23424_HoMM_Multithreading;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class Army {
    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() {
        List<PowerThread> powers = new ArrayList<>();

        units.forEach(unit -> {
            PowerThread powerThread = new PowerThread(unit);
            powerThread.start();
            powers.add(powerThread);
        });

        return powers.stream()
                .mapToInt(PowerThread::getUnitsPower)
                .sum();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}

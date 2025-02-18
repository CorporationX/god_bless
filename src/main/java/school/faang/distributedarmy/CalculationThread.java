package school.faang.distributedarmy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CalculationThread extends Thread {
    private final Squad squad;
    private int squadPower;

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }
}

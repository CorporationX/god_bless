package school.faang.stream3.distributedmarmymnm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SquadPowerCalculator extends Thread {
    private final Squad squad;

    @Override
    public void run() {
        System.out.printf("Calculation for %s in separate thread\n", squad.getName());
        int calculatedPower = squad.calculateSquadPower();
        squad.setCalculatedPower(calculatedPower);
    }
}

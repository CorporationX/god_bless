package bjs291241;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Squad {
    private final String name;
    private final List<Fighter> fighters;

    public int calculateSquadPower() {
        int totalPowerOfSquad = 0;
        for (Fighter fighter : fighters) {
            totalPowerOfSquad += fighter.getPower();
        }
        return totalPowerOfSquad;
    }
}

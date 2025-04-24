package school.faang.bjs2_72588;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Army {
    private final List<Squad> squads;

    public int calculateTotalPower() {
        for (Squad squad : squads) {
            Thread thread = new Thread(squad);
            thread.start();
        }

        return squads.stream().mapToInt(Squad::getTotalPower).sum();
    }
}

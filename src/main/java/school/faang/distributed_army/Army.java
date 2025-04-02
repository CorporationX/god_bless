package school.faang.distributed_army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad<? extends Hero>> squads;

    public Army(List<Squad<? extends Hero>> squads) {
        this.squads = squads;
    }

    public int calculateTotalPower() {
        List<SquadPowerCalculator> calculators = new ArrayList<>();

        for (Squad<? extends Hero> squad : squads) {
            SquadPowerCalculator squadPowerCalculator = new SquadPowerCalculator(squad);
            calculators.add(squadPowerCalculator);
            squadPowerCalculator.start();
        }
        try {
            for (SquadPowerCalculator squadPowerCalculator : calculators) {
                squadPowerCalculator.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return calculators.stream().mapToInt(SquadPowerCalculator::getTotalPower).sum();
    }
}

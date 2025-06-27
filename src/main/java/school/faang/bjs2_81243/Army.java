package school.faang.bjs2_81243;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Army {
    private List<Squad<? extends Fighter>> listOfSquads = new ArrayList<>();

    public void addSquad(Squad<? extends Fighter> squad) {
        listOfSquads.add(squad);
    }

    public int calculateTotalPower() {
        List<SquadPowerCalculator> calculators = new ArrayList<>();

        if (listOfSquads == null || listOfSquads.isEmpty()) {
            log.info("Отряда со значением null и пустого не существует");
        }

        for (Squad<? extends Fighter> squad : listOfSquads) {
            SquadPowerCalculator calculator = new SquadPowerCalculator(squad);
            calculators.add(calculator);
            calculator.start();
        }

        for (SquadPowerCalculator calculator : calculators) {
            try {
                calculator.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int total = 0;
        for (SquadPowerCalculator calculator : calculators) {
            total += calculator.getSquadPower();
        }

        return total;
    }
}

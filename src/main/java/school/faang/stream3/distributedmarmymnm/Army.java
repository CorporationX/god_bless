package school.faang.stream3.distributedmarmymnm;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Squad> squadList = new ArrayList<>();

    public void addSquad(Squad squad) {
        squadList.add(squad);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        List<SquadPowerCalculator> allThreads =
                squadList.stream()
                        .map(SquadPowerCalculator::new)
                        .peek(SquadPowerCalculator::start)
                        .toList();

        for (Thread thread : allThreads) {
            thread.join();
        }

        return squadList.stream()
                .mapToInt(Squad::getCalculatedPower)
                .sum();
    }

}

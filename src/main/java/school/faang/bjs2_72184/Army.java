package school.faang.bjs2_72184;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Army {
    private final List<Squad> squads = new ArrayList<>();
    private final List<Integer> totalPowerList = Collections.synchronizedList(new ArrayList<>());
    private final List<Thread> calcThreads = new ArrayList<>();

    public Integer calculateTotalPower() throws InterruptedException {
        for (Squad squad : squads) {
            Thread calcPowerThread = new Thread(() -> {
                Integer squadPower = squad.calculateSquadPower();
                log.debug("squad [{}] power is: {}", squad.getSquadName(), squadPower);
                totalPowerList.add(squadPower);
            });
            calcPowerThread.start();
            calcThreads.add(calcPowerThread);
        }

        for (Thread calcThread : calcThreads) {
            calcThread.join();
        }

        return totalPowerList.stream()
            .reduce(0, Integer::sum);
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}

package school.faang.naughtwoBJS261388;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower() {
        int numberOfSquads = squads.size();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfSquads);
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            executor.submit(() -> results.add(squad.calculateSquadPower()));
        }
        executor.shutdown();
        log.debug("Total power is calculated");
        return results.stream().mapToInt(Integer::intValue).sum();
    }

    public void addSquad(@NonNull Squad fighters) {
        squads.add(fighters);
    }
}

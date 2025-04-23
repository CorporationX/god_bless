package school.faang.armyofheroes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class Army {
    @NonNull
    private final List<Squad> squads;

    @SneakyThrows
    public int calculateTotalPower() {
        int totalPower = 0;
        Thread[] threads = new Thread[squads.size()];
        int[] results = new int[squads.size()];

        for (int i = 0; i < squads.size(); i++) {
            final int idx = i;
            threads[idx] = (new Thread(() -> results[idx] = squads.get(idx).calculateSquadPower()));
            threads[idx].start();
            log.info(String.format("Thread %d started.", idx));
        }
        for (int i = 0; i < squads.size(); i++) {
            threads[i].join();
            log.info(String.format("Thread %d result %d", i, results[i]));
            totalPower += results[i];
        }
        return totalPower;
    }

    public void addSquad(@NonNull Squad squad) {
        squads.add(squad);
    }
}

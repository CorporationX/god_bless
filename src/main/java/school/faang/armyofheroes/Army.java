package school.faang.armyofheroes;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class Army {
    private static final int THREAD_COUNT = 3;

    @NonNull
    private final List<Squad<? extends Hero>> squads;

    @SneakyThrows
    public int calculateTotalPower() {
        int totalPower = 0;
        int[] results = new int[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];

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
}

package school.faang.hero;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Army {

    private final List<Squad> squads = new ArrayList<>();
    private final List<Integer> powerSquads = new ArrayList<>();
    private final List<Thread> threads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int powerSquad = squad.calculateSquadPower();
                powerSquads.add(powerSquad);
                log.info("Создан поток {}", Thread.currentThread().getName());
            });
            thread.start();
            threads.add(thread);
            log.info("В работе поток {}", thread.getName());
        }
        for (Thread thread : threads) {
            thread.join();
            log.info("Ожидаем завершения потока{}", thread.getName());
        }
        return powerSquads.stream()
                .reduce(Integer::sum)
                .orElseGet(() -> {
                    log.warn("Список армии пуст");
                    return DefaultPower.DEFAULT_POWER;
                });
    }
}
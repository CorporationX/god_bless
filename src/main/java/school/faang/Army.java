package school.faang;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Data
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad... squads) {
        for (Squad squad : squads) {
            this.squads.add(squad);
        }
    }

    public int calculateArmyPower() throws InterruptedException  {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                try {
                    int power = squad.calculateSquadPower();
                    results.add(power);
                } catch (Exception e) {
                    log.info("Ошибка при вычислении силы отряда: " + e.getMessage());
                    results.add(0);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().mapToInt(Integer::intValue).sum();
    }

}

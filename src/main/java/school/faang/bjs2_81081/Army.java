package school.faang.bjs2_81081;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Army {
    private final List<Squad<?>> squads = new ArrayList<>();
    private final List<Integer> powers = new ArrayList<>();

    public int calculateTotalPower() {
        try {
            powers.clear();
            List<Thread> threads = new ArrayList<>(squads.size());

            for (Squad<?> squad : squads) {
                Thread thread = new Thread(() -> powers.add(squad.calculateSquadPower()));
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            int totalPower = powers.stream().mapToInt(Integer::intValue).sum();
            log.info("Общая сила армии: {}", totalPower);

            return totalPower;

        } catch (InterruptedException e) {
            log.error("Работа потока была прервана", e);
            return -1;
        }
    }

    public void addSquad(Squad<?> squad) {
        squads.add(squad);
    }
}

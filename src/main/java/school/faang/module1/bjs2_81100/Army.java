package school.faang.module1.bjs2_81100;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class Army {

    private final List<Squad<? extends Warrior>> squads;

    public int calculateTotalPower() {
        List<SquadPowerThread> threads = new ArrayList<>();

        for (Squad<? extends Warrior> squad : squads) {
            SquadPowerThread squadPowerThread = new SquadPowerThread(squad);
            threads.add(squadPowerThread);
            squadPowerThread.start();
        }

        for (SquadPowerThread squadPowerThread : threads) {
            try {
                squadPowerThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван во время ожидания завершения вычисления силы отряда", e);
            }
        }

        return threads.stream()
                .mapToInt(SquadPowerThread::getSquadPower)
                .sum();
    }
}
package school.faang.threadarmy;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Army {
    private List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<SquadThread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            SquadThread thread = new SquadThread(squad);
            threads.add(thread);
            thread.start();
        }

        for (SquadThread thread : threads) {
            thread.join();
        }

        return threads.stream()
                .mapToInt(SquadThread::getSquadPower)
                .sum();
    }
}

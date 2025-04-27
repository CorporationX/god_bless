package school.faang.heroes_of_might_and_magic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
@AllArgsConstructor
class Army {
    private List<Squad> squads;

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalPower = new AtomicInteger(0);
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : squads) {
            Thread thread = new Thread(() -> {
                int squadPower = squad.calculateSquadPower();
                totalPower.addAndGet(squadPower);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return totalPower.get();
    }
}
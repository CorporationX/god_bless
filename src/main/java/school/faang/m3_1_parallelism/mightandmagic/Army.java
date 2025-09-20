package school.faang.m3_1_parallelism.mightandmagic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class Army {
    private final List<Squad> squads;

    public int calculateTotalPower() {
        AtomicInteger resultPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>(squads.size());

        squads.forEach(squad -> {
            Thread thread = new Thread(
                    () -> resultPower.getAndAdd(squad.calculateSquadPower())
            );
            threads.add(thread);
            thread.start();
        });
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка в процессе расчета потока");
            }
        });
        return resultPower.get();
    }
}

package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Army {
    private List<Squad> squadList;

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger sum = new AtomicInteger();
        for (Squad squad : squadList) {
            Thread thread = new Thread(() -> sum.addAndGet(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
        }
        return sum.get();
    }
}

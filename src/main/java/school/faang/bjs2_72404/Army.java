package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Army {
    List<Squad> squadList;

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger sum = new AtomicInteger();
        for (int i = 0; i < squadList.size(); i++) {
            final int finalI = i;
            threads.add(new Thread(() -> sum.addAndGet(squadList.get(finalI).calculateSquadPower())));
            threads.get(i).start();
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

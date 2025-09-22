package school.faang.bjs2_91444;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    public static int calculateTotalPower(@NonNull List<Squad> army) {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (Squad squad : army) {
            Thread thread = new Thread(() -> totalPower.addAndGet(Squad.calculateSquadPower(squad)));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток main не смог дождаться, его прервали.");
            }
        }
        return totalPower.get();
    }
}

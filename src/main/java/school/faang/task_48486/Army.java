package school.faang.task_48486;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private static final int ARCHER_QUANTITY = 100;
    private static final int SWORDSMAN_QUANTITY = 100;
    private static final int MAGE_QUANTITY = 100;

    List<Character> mages = Collections.nCopies(MAGE_QUANTITY, new Mage());
    List<Character> swordsmen = Collections.nCopies(SWORDSMAN_QUANTITY, new Swordsman());
    List<Character> archers = Collections.nCopies(ARCHER_QUANTITY, new Archer());

    List<Thread> threads = new ArrayList<>();

    @SneakyThrows
    public int calculateTotalPower() {
        List<Character> army = new ArrayList<>();
        army.addAll(mages);
        army.addAll(swordsmen);
        army.addAll(archers);
        AtomicInteger totalPower = new AtomicInteger();

        for (Character character : army) {
            Thread thread = new Thread(() -> totalPower.addAndGet(character.getPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalPower.get();
    }
}

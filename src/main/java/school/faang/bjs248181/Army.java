package school.faang.bjs248181;

import school.faang.bjs248181.characters.Archer;
import school.faang.bjs248181.characters.Character;
import school.faang.bjs248181.characters.Mage;
import school.faang.bjs248181.characters.Swordsman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Army {
    private final List<Archer> archers = new ArrayList<>();
    private final List<Mage> mages = new ArrayList<>();
    private final List<Swordsman> swordsmen = new ArrayList<>();
    private final Consumer<Thread> threadWrapper = (thread) -> {
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Error in thread: " + thread.getName());
        }
    };

    public void addUnit(Character character) {
        if (character instanceof Archer) {
            archers.add((Archer) character);
        } else if (character instanceof Mage) {
            mages.add((Mage) character);
        } else if (character instanceof Swordsman) {
            swordsmen.add((Swordsman) character);
        }
    }

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger();
        List<Thread> threads = List.of(
                new Thread(() -> totalPower.addAndGet(archers.stream().mapToInt(Character::getPower).sum())),
                new Thread(() -> totalPower.addAndGet(mages.stream().mapToInt(Character::getPower).sum())),
                new Thread(() -> totalPower.addAndGet(swordsmen.stream().mapToInt(Character::getPower).sum()))
        );
        threads.forEach(threadWrapper);

        return totalPower.get();
    }

}

package faang.school.godbless.multithreading_parallelism.army_of_heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {

        AtomicInteger aIMage = new AtomicInteger();
        AtomicInteger aIArcher = new AtomicInteger();
        AtomicInteger aISwordsman = new AtomicInteger();

        Thread threadMage = new Thread(() -> {
            aIMage.set(units.stream()
                    .filter(unit -> unit.isMage())
                    .map(unit -> unit.getPower())
                    .reduce(0, (a, b) -> a + b));
        });
        Thread threadArcher = new Thread(() -> {
            aIArcher.set(units.stream()
                    .filter(unit -> unit.isArcher())
                    .mapToInt(Unit::getPower)
                    .sum());
        });
        Thread threadSwordsman = new Thread(() -> {
            aISwordsman.set(units.stream()
                    .filter(unit -> unit.isSwordsman())
                    .map(unit -> unit.getPower())
                    .reduce(0, (a, b) -> a + b));
        });


        threadMage.start();
        threadArcher.start();
        threadSwordsman.start();

        try {
            threadMage.join();
            threadArcher.join();
            threadSwordsman.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return aIMage.get() + aIArcher.get() + aISwordsman.get();


    }
}

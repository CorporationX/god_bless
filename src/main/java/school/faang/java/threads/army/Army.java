package school.faang.java.threads.army;

import school.faang.java.threads.items.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private final Map<String, List<Unit>> listArmy = new HashMap<>();

    public void setItemToMapList(Unit anyItemHero) {
        listArmy.putIfAbsent(anyItemHero.getClass().getName(), new ArrayList<>());
        listArmy.get(anyItemHero.getClass().getName()).add(anyItemHero);
    }

    /// Experiment for the history - step by step
    public void calculatePowerV1() {
        listArmy.entrySet()
                .stream()
                .map(stringListEntry -> stringListEntry.getValue().stream()
                        .map(item -> {
                            Thread thread = new Thread(() -> item.setCalculatedItemPower(stringListEntry.getKey()));
                            thread.start();
                            return thread;
                        })
                )
                .forEach(threadStream -> threadStream.forEach(thread -> {
                            try {
                                thread.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        })
                );
    }

    /// Experiment for the history - step by step
    public void calculatePowerV2() {
        listArmy.values().stream()
                .flatMap(list -> list.stream())
                .map(item -> {
                    Thread thread = new Thread(() -> item.setCalculatedItemPower("V2: Без определения Key: " + item.getClass().getName()));
                    thread.start();
                    return thread;
                })
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /// it is working variant
    public void calculatePowerV3() {
        List<Thread> tempThread = new ArrayList<>();
        listArmy.values().stream()
                .flatMap(list -> list.stream())
                .forEach(item -> {
                    Thread thread = new Thread(() -> item.setCalculatedItemPower("V3: Без определения Key: " + item.getClass().getName()));
                    thread.start();
                    tempThread.add(thread);
                });

        tempThread.forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public int calculateTotalPower() {
        return listArmy.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Unit::getPower)
                .sum();
    }
}

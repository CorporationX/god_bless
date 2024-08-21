package faang.school.godbless.BJS2_23405;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class Army {
    private final Map<String, List<Character>> army = new HashMap<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public void addCharacter(Character character) {
        army.computeIfAbsent(character.getClass().getSimpleName(), key -> new ArrayList<>()).add(character);
    }

    public int calculateTotalPower() {
        List<Thread> threads = army.values().stream()
                .map(this::createTask)
                .map(Thread::new)
                .toList();
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread error");
            }
        });
        return totalPower.get();
    }

    private Runnable createTask(List<Character> characters) {
        return () -> {
            int localTotalPower = characters.stream()
                    .map(Character::getPower)
                    .reduce(Integer::sum)
                    .orElseThrow();
            totalPower.addAndGet(localTotalPower);
        };
    }
}
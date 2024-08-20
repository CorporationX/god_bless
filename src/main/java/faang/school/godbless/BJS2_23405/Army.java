package faang.school.godbless.BJS2_23405;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Army {
    private final Map<Character, Integer> army = new HashMap<>();
    private int totalPower;

    public void add(Character character, int quantity) {
        army.putIfAbsent(character, 0);
        army.put(character, army.get(character) + quantity);
    }

    public int calculateTotalPower() {
        totalPower = 0;
        List<Thread> threads = army.entrySet().stream()
                .map(this::createTask)
                .map(Thread::new)
                .peek(Thread::start)
                .toList();
        threads.forEach(this::joinThread);
        return totalPower;
    }

    private Runnable createTask(Map.Entry<Character, Integer> entry) {
        return () -> {
            synchronized (this) {
                totalPower += entry.getKey().getPower() * entry.getValue();
            }
        };
    }

    private void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread error");
        }
    }
}
package school.faang.heros;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> characters = new ArrayList<>();

    public synchronized void addUnit(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> totalPower = new ArrayList<>();

        synchronized (characters) {
            for (Character character : characters) {
                Thread thread = new Thread(() -> totalPower.add(character.getPower()));
                threads.add(thread);
                thread.start();
            }
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return totalPower.stream().mapToInt(Integer::valueOf).sum();
    }
}

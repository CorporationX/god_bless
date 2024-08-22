package faang.school.godbless.bjs2_23452;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private final Map<String, List<Character>> characters;

    public Army() {
        characters = new HashMap<>();
    }

    public void addUnit(Character character) {
        String characterClassName = character.getClass().getSimpleName();
        characters.computeIfAbsent(characterClassName, value -> new ArrayList<>()).add(character);
    }

    public int calculateTotalPower() {
        List<CustomThread> threads = new ArrayList<>();
        characters.forEach((key, value) -> {
            CustomThread thread = new CustomThread(value, key);
            threads.add(thread);
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return threads.stream()
                .mapToInt(CustomThread::getPower)
                .sum();
    }
}

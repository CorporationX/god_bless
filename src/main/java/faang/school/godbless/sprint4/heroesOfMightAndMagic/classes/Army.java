package faang.school.godbless.sprint4.heroesOfMightAndMagic.classes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> army = new ArrayList<>();

    public void addUnit(Character character) {
        army.add(character);
    }

    public int calculateTotalPower() {
        List<CharacterThread> threads = new ArrayList<>();
        army.forEach(
                character -> {
                    CharacterThread thread = new CharacterThread(character.getPower());
                    threads.add(thread);
                    thread.start();
                }
        );
        return threads.stream()
                .mapToInt(CharacterThread::getTotalPower)
                .sum();
    }
}

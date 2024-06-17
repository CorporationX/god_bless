package faang.school.godbless.multithreading.army;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {

    public final static List<Character> characters = new ArrayList<>();

    public final static Map<Character, Integer> totalCharacter = new HashMap<>();

    public void addUnit(Character character) {
        characters.add(character);

        ThreadDistribution threadDistribution = new ThreadDistribution(character, totalCharacter);
        Thread thread = new Thread(threadDistribution);
        thread.start();
    }

    public int calculateTotalPower() {
        return totalCharacter.values().stream().mapToInt(t -> t).sum();
    }
}
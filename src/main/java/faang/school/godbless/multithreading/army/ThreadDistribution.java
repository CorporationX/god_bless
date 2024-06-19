package faang.school.godbless.multithreading.army;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ThreadDistribution implements Runnable {

    public Character character;

    public Map<Character, Integer> totalChar;

    @Override
    public void run() {
        if (totalChar.containsKey(character)) {
            totalChar.put(character, totalChar.get(character) + character.getPower());
        }
        totalChar.put(character, character.getPower());
    }
}
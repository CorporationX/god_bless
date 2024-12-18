package school.faang.bjs248181;

import school.faang.bjs248181.characters.Archer;
import school.faang.bjs248181.characters.Character;
import school.faang.bjs248181.characters.CharacterType;
import school.faang.bjs248181.characters.Mage;
import school.faang.bjs248181.characters.Swordsman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    private final Map<CharacterType, List<Character>> charactersMap = new HashMap<>();

    public void addUnit(Character character) {
        if (character instanceof Archer) {
            putInMap(CharacterType.ARCHER, character);
        } else if (character instanceof Mage) {
            putInMap(CharacterType.MAGE, character);
        } else if (character instanceof Swordsman) {
            putInMap(CharacterType.SWORDSMAN, character);
        }
    }

    public int calculateTotalPower() {
        return charactersMap.entrySet()
                .stream().map(Army::calculatePower)
                .reduce(0, Integer::sum);
    }

    private void putInMap(CharacterType swordsman, Character character) {
        charactersMap.computeIfAbsent(swordsman, x -> new ArrayList<>()).add(character);
    }

    private static int calculatePower(Map.Entry<CharacterType, List<Character>> charactersByType) {
        AtomicInteger totalPower = new AtomicInteger();
        Thread thread = new Thread(() ->
                totalPower.addAndGet(charactersByType
                        .getValue()
                        .stream()
                        .mapToInt(Character::getPower).
                        sum()));
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Error in thread: " + thread.getName());
        }
        return totalPower.get();
    }
}

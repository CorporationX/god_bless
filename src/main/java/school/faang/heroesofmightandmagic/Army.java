package school.faang.heroesofmightandmagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private final List<Character> characters = new ArrayList<>();
    private final List<Class<? extends Character>> characterTypes
            = new ArrayList<>(List.of(Archer.class, Swordsman.class, Mage.class));

    public void addUnit(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        HashMap<Thread, TotalPowerRunner> threadsAndRunners = new HashMap<>();

        characterTypes.forEach(characterType -> {
            TotalPowerRunner totalPowerRunner = new TotalPowerRunner(
                    characters.stream().filter(character -> character.getClass() == characterType).toList());

            Thread characterThread = new Thread(totalPowerRunner);

            threadsAndRunners.put(characterThread, totalPowerRunner);

            characterThread.start();
        });

        int result = 0;
        for (Map.Entry<Thread, TotalPowerRunner> entry : threadsAndRunners.entrySet()) {
            entry.getKey().join();
            result += entry.getValue().getTotalPower();
        }

        return result;
    }
}

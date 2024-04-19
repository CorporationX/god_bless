package Multithreading_ArmyOfTheHeroes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private List<Character> characters;

    public Army(List<Character> characters) {
        this.characters = characters;
    }

    public int calculateTotalPower() throws InterruptedException {
        List<CharacterPowerThread> characterPowerThreads = new ArrayList<>();
        characters.forEach(character -> startingThreads(character, characterPowerThreads));

        return getSumPower(characterPowerThreads);
    }

    private void startingThreads(Character character, List<CharacterPowerThread> charsThread) {
        CharacterPowerThread characterPowerThread = new CharacterPowerThread(character);
        charsThread.add(characterPowerThread);
        characterPowerThread.start();
    }

    private int getSumPower(List<CharacterPowerThread> chars) throws InterruptedException {
        int totalPower = 0;
        for (CharacterPowerThread thread : chars) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }
}

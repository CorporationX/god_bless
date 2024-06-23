package faang.school.godbless.multithreading.heroesArmy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Army {

    private List<Character> characters;

    public Army() {
        this.characters = new ArrayList<>();
    }

    public int calculateTotalPower() {
        List<CharacterThread> characterThreads = new ArrayList<>();
        characters.forEach(character -> characterThreads.add(new CharacterThread(character, character.getPower())));
        return getTotalPower(characterThreads);
    }

    private int getTotalPower(List<CharacterThread> characterThreads) {
        for (CharacterThread characterThread : characterThreads) {
            characterThread.start();
        }
        return calculatePower(characterThreads);
    }

    private int calculatePower(List<CharacterThread> characterThreads) {
        int totalPower = 0;
        for (CharacterThread characterThread : characterThreads) {
            try {
                characterThread.join();
                totalPower += characterThread.getPower();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return totalPower;
    }

    public void addUnit(@NonNull Character character) {
        characters.add(character);
    }
}

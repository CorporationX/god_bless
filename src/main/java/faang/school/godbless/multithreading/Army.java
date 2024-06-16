package faang.school.godbless.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Army {

    private List<Character> armies;

    public Army() {
        this.armies = new ArrayList<>();
    }

    public int calculateTotalPower() {
        List<CharacterThread> characterThreads = new ArrayList<>();
        armies.forEach(character -> characterThreads.add(new CharacterThread(character, character.getPower())));
        return getTotalPower(characterThreads);
    }

    private int getTotalPower(List<CharacterThread> characterThreads) {
        int totalPower = 0;
        for (CharacterThread characterThread : characterThreads) {
            characterThread.start();
            try {
                characterThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += characterThread.getPower();
        }
        return totalPower;
    }

    public void addUnit(@NonNull Character character) {
        armies.add(character);
    }
}

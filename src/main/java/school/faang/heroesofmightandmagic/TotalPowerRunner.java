package school.faang.heroesofmightandmagic;

import java.util.List;

public class TotalPowerRunner implements Runnable {
    private final List<Character> characterList;
    private int totalPower = 0;

    public TotalPowerRunner(List<Character> characterList) {
        this.characterList = characterList;
    }

    @Override
    public void run() {
        totalPower += characterList.stream().mapToInt(Character::getPower).sum();
    }

    public int getTotalPower() {
        return totalPower;
    }
}

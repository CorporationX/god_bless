package faang.school.godbless.BJS211012;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Character> characterList;
    private List<CharacterThread> swordsmanPower;
    private List<CharacterThread> magePower;
    private List<CharacterThread> archerPower;

    public void addUnit(Character unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit is null");
        }
        characterList.add(unit);
    }

    public Army() {
        this.characterList = new ArrayList<>();
        this.swordsmanPower = new ArrayList<>();
        this.magePower = new ArrayList<>();
        this.archerPower = new ArrayList<>();
    }

    public Army(List<Character> characters) {
        this.characterList = characters;
        this.swordsmanPower = new ArrayList<>();
        this.magePower = new ArrayList<>();
        this.archerPower = new ArrayList<>();
    }

    public int calculateTotalPower() throws InterruptedException {
        startAllThreads();
        return getTotalPower();
    }

    private int getTotalPower() throws InterruptedException {
        int totalMage = 0;
        int totalArcher = 0;
        int totalSwordsman = 0;
        for (var mage : magePower) {
            mage.join();
            totalMage += mage.getResult();
        }
        for (var archer : archerPower) {
            archer.join();
            totalArcher += archer.getResult();
        }
        for (var swordsman : swordsmanPower) {
            swordsman.join();
            totalArcher += swordsman.getResult();
        }
        return totalMage + totalArcher + totalSwordsman;
    }

    private void startAllThreads() {
        for (var character : characterList) {
            if (character.isMage()) {
                CharacterThread characterThread = new CharacterThread(character);
                characterThread.start();
                magePower.add(characterThread);
            }
            if (character.isArcher()) {
                CharacterThread characterThread = new CharacterThread(character);
                characterThread.start();
                archerPower.add(characterThread);
            }
            if (character.isSwordsman()) {
                CharacterThread characterThread = new CharacterThread(character);
                characterThread.start();
                archerPower.add(characterThread);
            }
        }
    }
}

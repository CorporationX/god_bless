package Multithreading_ArmyOfTheHeroes;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private List<Character> characters;
    private List<CharacterPowerThread> archersPowerThread = new ArrayList<>();
    private List<CharacterPowerThread> magesPowerThread = new ArrayList<>();
    private List<CharacterPowerThread> swordsmenPowerThread = new ArrayList<>();

    public Army(List<Character> characters) {
        this.characters = characters;
    }

    public int calculateTotalPower() throws InterruptedException {
        characters.forEach(character -> {
            if (character.isArcher()) {
                startingThreads(character, archersPowerThread);
            } else if (character.isMage()) {
                startingThreads(character, magesPowerThread);
            } else if (character.isSwordsman()) {
                startingThreads(character, swordsmenPowerThread);
            }
        });

        int archersPower = getSumPower(archersPowerThread);
        int magesPower = getSumPower(magesPowerThread);
        int swordsmenPower = getSumPower(swordsmenPowerThread);

        System.out.println("Archers total power " + archersPower);
        System.out.println("Mages total power " + magesPower);
        System.out.println("Swordsmen total power " + swordsmenPower);

        return archersPower + magesPower + swordsmenPower;
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

package faang.school.godbless.Army_Of_Heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<CharacterThread> archers = new ArrayList<>();
    List<CharacterThread> swordsmen = new ArrayList<>();
    List<CharacterThread> mages = new ArrayList<>();
    private final List<Character> characters;

    public int calculateTotalPower() throws InterruptedException {
        //int totalPowerArmy = 0;
        for (Character character : characters) {
            if (character instanceof Archer) {
                CharacterThread characterThread = new CharacterThread(character);
                archers.add(characterThread);
                characterThread.start();
            } else if (character instanceof Swordsman) {
                CharacterThread characterThread = new CharacterThread(character);
                swordsmen.add(characterThread);
                characterThread.start();
            } else if (character instanceof Mage) {
                CharacterThread characterThread = new CharacterThread(character);
                mages.add(characterThread);
                characterThread.start();
            }
        }
        int totalPowerArchers = 0;
        for (CharacterThread archer : archers) {
            archer.join();
            totalPowerArchers += archer.getPower();
        }
        int totalPowerSwordsmen = 0;
        for (CharacterThread swordsman : swordsmen) {
            swordsman.join();
            totalPowerSwordsmen += swordsman.getPower();
        }
        int totalPowerMages = 0;
        for (CharacterThread mage : mages) {
            mage.join();
            totalPowerMages += mage.getPower();
        }
        System.out.println(totalPowerMages);
        System.out.println(totalPowerArchers);
        System.out.println(totalPowerSwordsmen);
        return totalPowerMages + totalPowerArchers + totalPowerSwordsmen;
    }

    public Army(List<Character> units) {
        this.characters = units;
    }
}

package faang.school.godbless.swordandmagic;

import java.util.ArrayList;
import java.util.List;


public class Army {

    private List<Character> characters;
    private List<CharacterThreads> mageThreads = new ArrayList<>();
    private List<CharacterThreads> archerThreads = new ArrayList<>();
    private List<CharacterThreads> swordsmanThreads = new ArrayList<>();

    public Army(List<Character> characters) {
        this.characters = characters;
    }

    public int calculateTotalPower() throws InterruptedException {

        for (Character character : characters) {
            if (character.isMage()) {
                CharacterThreads powerThread = new CharacterThreads(character);
                mageThreads.add(powerThread);
                powerThread.start();
            } else if (character.isArcher()) {
                CharacterThreads powerThread = new CharacterThreads(character);
                archerThreads.add(powerThread);
                powerThread.start();
            } else if (character.isSwordsman()) {
                CharacterThreads powerThread = new CharacterThreads(character);
                swordsmanThreads.add(powerThread);
                powerThread.start();
            }

        }
        int totalSwordsmenPower = getPowerSum(swordsmanThreads);
        int totalArcherPower = getPowerSum(archerThreads);
        int totalMagePower = getPowerSum(mageThreads);

        return totalMagePower + totalArcherPower + totalSwordsmenPower;
    }


    private int getPowerSum(List<CharacterThreads> characters) throws InterruptedException {
        int totalPower = 0;
        for (CharacterThreads mageThread : characters) {
            mageThread.join();
            totalPower += mageThread.getPower();
        }
        return totalPower;
    }

}

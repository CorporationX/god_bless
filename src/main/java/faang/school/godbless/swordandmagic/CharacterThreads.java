package faang.school.godbless.swordandmagic;

public class CharacterThreads extends Thread {
    private int power;
    private final Character character;

    public CharacterThreads(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }

    public int getPower() {
        return power;
    }
}

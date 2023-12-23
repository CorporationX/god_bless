package faang.school.godbless.Army_Of_Heroes;

import lombok.Getter;

public class CharacterThread extends Thread {
    private final Character character;
    @Getter
    private int power;

    public CharacterThread(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }

}

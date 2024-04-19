package Multithreading_ArmyOfTheHeroes;

import lombok.Getter;

public class CharacterPowerThread extends Thread {
    private Character character;

    @Getter
    private int power;

    public CharacterPowerThread(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }
}

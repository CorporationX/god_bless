package HeroesOfMightAndMagics;

import lombok.Getter;


@Getter
public class ArmyPowerThread extends Thread {
    private final Character character;
    private int currentPower;

    public ArmyPowerThread(Character character) {
        this.character = character;
    }


    @Override
    public void run() {
        currentPower = character.getPower();
    }
}

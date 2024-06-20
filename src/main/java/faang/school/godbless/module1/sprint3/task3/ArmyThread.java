package faang.school.godbless.module1.sprint3.task3;

import lombok.Getter;

@Getter
public class ArmyThread extends Thread {
    private final Characters characters;
    private int power;

    public ArmyThread(Characters characters) {
        this.characters = characters;

    }

    @Override
    public void run(){
        power = characters.getPower();
    }
}

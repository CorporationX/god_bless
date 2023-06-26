package faang.school.godbless.sprint_3.multithreading.distributed_army;

import lombok.Getter;
import lombok.Setter;


public class NumberHolder extends Thread {
    @Getter
    @Setter
    private int power;
    Character character;

    public NumberHolder(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        setPower(character.getPower());
    }
}

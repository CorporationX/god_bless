package faang.school.godbless.BJS2_11210;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ArmyThread extends Thread {
    private Character character;
    private int powerCharacter;
    public ArmyThread(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        powerCharacter = character.getPower();
    }
}
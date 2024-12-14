package faang.school.godbless.BJS211012;

import lombok.Getter;

@Getter
public class CharacterThread extends Thread {
    private int result;
    private final Character unit;

    public CharacterThread(Character unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        result = unit.getPower();
    }

}

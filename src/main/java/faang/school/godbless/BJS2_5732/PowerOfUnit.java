package faang.school.godbless.BJS2_5732;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PowerOfUnit extends Thread {
    private final Character character;
    private int power;

    @Override
    public void run() {
        power = character.getPower();
    }
}

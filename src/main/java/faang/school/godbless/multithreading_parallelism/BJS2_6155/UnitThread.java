package faang.school.godbless.multithreading_parallelism.BJS2_6155;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UnitThread extends Thread {
    private final Character character;
    private int power;

    @Override
    public void run() {
        power = character.getPower();
    }
}

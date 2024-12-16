package school.faang.task_47623;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import school.faang.task_47623.model.Character;

@RequiredArgsConstructor
public class PowerCalculator implements Runnable {
    private final Character character;
    @Getter
    private int power;

    @Override
    public void run() {
        power = character.getPower();
    }
}

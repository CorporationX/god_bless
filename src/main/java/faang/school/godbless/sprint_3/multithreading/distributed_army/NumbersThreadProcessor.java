package faang.school.godbless.sprint_3.multithreading.distributed_army;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class NumbersThreadProcessor extends Thread {
    @Getter
    @Setter
    private int power;
    private final Character character;

    @Override
    public void run() {
        setPower(character.getPower());
    }
}

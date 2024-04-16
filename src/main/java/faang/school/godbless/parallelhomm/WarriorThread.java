package faang.school.godbless.parallelhomm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WarriorThread extends Thread {
    private final Warrior warrior;
    private int power;

    @Override
    public void run() {
        power = warrior.getPower();
    }
}

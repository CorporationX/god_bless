package school.faang.task47604;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PowerThread extends Thread {
    private final Warrior warrior;
    private int power;

    @Override
    public void run() {
        power = warrior.getPower();
        super.run();
    }
}

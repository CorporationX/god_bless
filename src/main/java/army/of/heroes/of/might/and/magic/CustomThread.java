package army.of.heroes.of.might.and.magic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomThread extends Thread {
    private int totalPower;
    private final Creature creature;

    @Override
    public void run() {
        this.totalPower = this.creature.getPower();
    }
}

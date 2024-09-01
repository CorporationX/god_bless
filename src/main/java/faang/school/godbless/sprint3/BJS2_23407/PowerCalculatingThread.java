package faang.school.godbless.sprint3.BJS2_23407;

import lombok.Getter;
import lombok.NonNull;

public class PowerCalculatingThread extends Thread{
    @Getter
    private int power;
    private Hero hero;

    public PowerCalculatingThread(@NonNull Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        power = hero.getPower();
    }
}

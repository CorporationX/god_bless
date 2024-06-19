package faang.school.godbless.multithreading.heroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PowerThread extends Thread {

    private final Soldier soldier;
    private int power;

    @Override
    public void run() {
        this.power = this.soldier.getPower();
    }

}

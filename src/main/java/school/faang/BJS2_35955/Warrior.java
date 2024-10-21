package school.faang.BJS2_35955;

import java.util.concurrent.atomic.AtomicInteger;

public class Warrior implements Runnable{
    protected int power;
    protected AtomicInteger counter;

    @Override
    public void run() {
        counter.getAndAdd(power);
    }
}

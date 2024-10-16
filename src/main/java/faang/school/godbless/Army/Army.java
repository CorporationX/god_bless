package faang.school.godbless.Army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<er> d  = new ArrayList<>();

    int calculateTotalPower(){
        for (Thread i : d) {
            i.start();
        }
        try {
            for (Thread thread : d) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public void addUnit(er t) {
       d.add(t);
    }
}
 class PowerCalculator implements Runnable {
    private final er unit;
    private int power;

    public PowerCalculator(er unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }

    public int getPower() {
        return power;
    }
}
class er  {
    private int power;

    public er(int t) {
        System.out.println("поток " );
    }

    public int getPower() {
        return power;
    }
}

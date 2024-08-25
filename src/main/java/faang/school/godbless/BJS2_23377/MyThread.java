package faang.school.godbless.BJS2_23377;

import lombok.Getter;

@Getter
public class MyThread extends Thread{
    private int sumPower;
    private Unit unit;

    public MyThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        sumPower = unit.getPower();
    }
}

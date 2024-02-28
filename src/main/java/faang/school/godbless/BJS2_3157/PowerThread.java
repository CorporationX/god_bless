package faang.school.godbless.BJS2_3157;

import lombok.Getter;

public class PowerThread extends Thread{
    @Getter
    private int power;
    private final Unit unit;

    PowerThread(Unit unit){
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}

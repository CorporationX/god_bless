package faang.school.godbless.army;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PowerThread extends Thread{
    private int power;
    private Unit unit;

    public PowerThread(Unit unit){
        this.unit = unit;
    }

    @Override
    public void run() {
        power = unit.getPower();
    }
}

package faang.school.godbless.magicheroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TotalPowerThread extends Thread{
    private final Unit unit;
    private int power;

    public void run(){
        power = unit.getPower();
    }
}

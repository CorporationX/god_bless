package distributedArmy;

import lombok.Data;
import lombok.Getter;

@Getter
public class PowerThread extends Thread{
    private int power;
    private Unit unit;
    PowerThread(Unit unit){
        this.unit=unit;
        this.power=unit.getPower();
    }



}

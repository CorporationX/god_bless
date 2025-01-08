package distributed_army_heroes_might_and_magic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PowerThread extends Thread {
    private int power;
   final private Unit unit;

    public PowerThread(Unit unit) {
        this.unit = unit;
    }
    @Override
    public void run(){
        power = unit.getPower();
    }
}

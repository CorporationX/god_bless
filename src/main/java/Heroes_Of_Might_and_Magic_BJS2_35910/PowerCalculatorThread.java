package Heroes_Of_Might_and_Magic_BJS2_35910;

import lombok.Getter;

@Getter
public class PowerCalculatorThread extends Thread {
    private Object unit;
    private int result;

    public PowerCalculatorThread(Object unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        if (unit instanceof Archer) {
            result = ((Archer) unit).getPower();
        } else if (unit instanceof Swordsman) {
            result = ((Swordsman) unit).getPower();
        } else if (unit instanceof Mage) {
            result = ((Mage) unit).getPower();
        }
    }
}

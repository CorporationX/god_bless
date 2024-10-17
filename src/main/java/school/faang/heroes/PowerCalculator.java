package school.faang.heroes;

import lombok.Data;

@Data
class PowerCalculator implements Runnable {
    private final Object unit;
    private int power;

    @Override
    public void run() {
        if (unit instanceof Archer) {
            power = ((Archer) unit).getPower();
        } else if (unit instanceof Swordsman) {
            power = ((Swordsman) unit).getPower();
        } else if (unit instanceof Mage) {
            power = ((Mage) unit).getPower();
        }
    }

}

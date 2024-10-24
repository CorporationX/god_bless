package school.faang.java.threads.items;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    public void setCalculatedItemPower(String nameUnit) {
        // Imitation calculation
        int oldPower = power;
        try {
            Thread.sleep(power);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        power++;
        System.out.printf("\nCalculated a power for an item. Unit: %s, old power: %d power: %d."
                , nameUnit
                , oldPower
                , power);
    }
}
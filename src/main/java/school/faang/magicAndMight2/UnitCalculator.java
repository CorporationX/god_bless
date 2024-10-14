package school.faang.magicAndMight2;

import lombok.Getter;

@Getter
public class UnitCalculator implements Runnable {
    private final Unit unit;
    private int power;

    public UnitCalculator(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
        System.out.println("Unit is processed: " + unit);
    }
}
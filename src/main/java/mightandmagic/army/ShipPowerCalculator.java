package mightandmagic.army;

import lombok.Getter;

@Getter
public class ShipPowerCalculator extends Thread {
    private final Ship ship;
    private int totalPower;

    public ShipPowerCalculator(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void run() {
        System.out.println("Поток "
                + getName()
                + " запущен для обработки мощности корабля класса "
                + ship
        );

        totalPower = ship.getPower();

        System.out.println("Поток "
                + getName()
                + " завершил обработку корабля класса "
                + ship
        );
    }

    @Override
    public String toString() {
        return getName();
    }
}

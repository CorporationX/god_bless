package school.faang.heroes;

import lombok.Getter;

@Getter
public class Account implements Runnable {
    private Unit unit;
    private int power;

    public Account(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        this.power = unit.getPower();
    }

}

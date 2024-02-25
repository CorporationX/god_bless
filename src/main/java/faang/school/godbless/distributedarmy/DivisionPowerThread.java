package faang.school.godbless.distributedarmy;

import lombok.Getter;

@Getter
public class DivisionPowerThread extends Thread {
    private final Divisions division;
    private int power;

    public DivisionPowerThread(Divisions division) {
        this.division = division;
    }

    @Override
    public void start() {
        power = power + division.getPower();
    }
}

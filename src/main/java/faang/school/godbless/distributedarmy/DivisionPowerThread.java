package faang.school.godbless.distributedarmy;

import lombok.Getter;

@Getter
public class DivisionPowerThread extends Thread {
    private final Division division;
    private int power;

    public DivisionPowerThread(Division division) {
        this.division = division;
    }

    @Override
    public void run() {
        power = power + division.getPower();
    }
}
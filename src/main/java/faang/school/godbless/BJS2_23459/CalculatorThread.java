package faang.school.godbless.BJS2_23459;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CalculatorThread extends Thread{
    private int divisionTotalPower;
    private final List<Division> divisions;

    public CalculatorThread(List<Division> divisions) {
        this.divisions = divisions;
    }

    @Override
    public void run() {
        divisionTotalPower = divisions.stream()
                .mapToInt(Division::getPower)
                .sum();
    }
}

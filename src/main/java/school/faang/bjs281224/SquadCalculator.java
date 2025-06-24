package school.faang.bjs281224;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SquadCalculator extends Thread {
    private final Squad squad;
    private int result;

    @Override
    public void run() {
        result = squad.calculateSquadPower();
        System.out.printf("Сила отряда %s: %d%n", squad.getName(), result);
    }
}

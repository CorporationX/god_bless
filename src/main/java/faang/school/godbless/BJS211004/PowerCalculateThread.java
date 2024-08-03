package faang.school.godbless.BJS211004;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PowerCalculateThread extends Thread {

    private int powerSum;
    private final List<Unit> subArmy;

    @SneakyThrows
    @Override
    public void run() {
        if (subArmy != null && !subArmy.isEmpty()) {
            System.out.println(String.format("Считает поток %s для %s ", Thread.currentThread().getName(), subArmy.size(), subArmy.get(0).getClass().getSimpleName()));
            Thread.sleep(3000 * subArmy.size());
            powerSum = subArmy.stream().mapToInt(Unit::getPower).sum();
            System.out.println(String.format("Суммарная сила подразделения %s: %s", subArmy.get(0).getClass().getSimpleName(), powerSum));
        }
    }
}

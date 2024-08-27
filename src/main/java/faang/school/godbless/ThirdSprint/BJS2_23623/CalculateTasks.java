package faang.school.godbless.ThirdSprint.BJS2_23623;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CalculateTasks implements Runnable {

    private final List<Unit> list = new ArrayList<>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        list.stream().forEach(u -> u.totalPowerIncrement(u.getPower()));
    }
}

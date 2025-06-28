package school.faang.bjs2_82749_three_wiz_tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger(0);

    public int addPoints(int rewardPoints) {
        return points.addAndGet(rewardPoints);
    }
}

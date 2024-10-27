package school.faang.sprint_4.bjs2_38338_starWarsArena;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Robot {
    private final String name;
    private final int attackPower;
    private final int defencePower;
    private final AtomicInteger score = new AtomicInteger(0);

    public int addPoint() {
        return score.incrementAndGet();
    }

    public int getScore() {
        return score.get();
    }
}

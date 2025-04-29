package school.faang.async.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Student {

    private final String name;
    private final int year;
    private AtomicInteger points;

    public void addPoints(int reward) {
        this.getPoints().getAndAdd(reward);
    }
}

package school.faang.sprint4_future_async.thetriwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    @Getter
    private AtomicInteger points;

    public void addPoints(int point) {
        this.points.addAndGet(point);
    }
}
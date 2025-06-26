package school.faang.bjs2_82727;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"name"})
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public synchronized void setPoints(int reward) {
        this.points += reward;
    }

    public synchronized int getPoints() {
        return points;
    }
}

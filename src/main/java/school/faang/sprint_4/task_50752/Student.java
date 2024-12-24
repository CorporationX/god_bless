package school.faang.sprint_4.task_50752;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @NonNull
    private final String name;
    private final int year;
    private int points;

    public synchronized void addPoints(int reward) {
        points += reward;
    }

    public synchronized int getPoints() {
        return points;
    }

    public synchronized void setPoints(int points) {
        this.points = points;
    }
}

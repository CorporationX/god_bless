package school.faang.sprint_4.task_bjs250835;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class Student {
    @NonNull
    private final String name;
    private final int year;
    @Getter
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}

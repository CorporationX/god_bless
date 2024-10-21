package school.faang.multithreading.asynchronism.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points+=points;
    }
}

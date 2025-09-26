package school.faang.bjs2_92896;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public synchronized void addPoints(int points) {
        this.points += points;
    }
}
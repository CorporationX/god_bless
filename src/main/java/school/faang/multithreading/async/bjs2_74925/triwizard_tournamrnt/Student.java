package school.faang.multithreading.async.bjs2_74925.triwizard_tournamrnt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}

package school.faang.asynchrony.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private Integer year;
    private Integer points;

    public void addPoints(Integer reward) {
        this.points += reward;
    }
}

package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private int year;
    private int point;

    public void addPoint(int point) {
        this.point += point;
    }
}

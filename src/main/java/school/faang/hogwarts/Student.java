package school.faang.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private String name;
    private int year;
    private int reward;

    public void updatePoints(int reward) {
        this.reward += reward;
    }

}

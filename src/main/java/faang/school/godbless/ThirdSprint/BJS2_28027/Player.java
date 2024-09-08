package faang.school.godbless.ThirdSprint.BJS2_28027;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized Player increaseExp(int delta){
        experience += delta;
        return this;
    }
}

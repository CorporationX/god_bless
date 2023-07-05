package faang.school.godbless.task.skyNet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Target {
    private String name;
    private boolean isAlive;

    public Target(String name) {
        this.name = name;
        this.isAlive = true;
    }
}

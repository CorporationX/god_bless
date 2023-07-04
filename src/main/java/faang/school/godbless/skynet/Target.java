package faang.school.godbless.skynet;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Target {

    private String name;
    @Setter
    private int health = 100;

    public Target(String name) {
        this.name = name;
    }
}

package faang.school.godbless.broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int leave;
    private int score;
    private Boolean isAlive;
}

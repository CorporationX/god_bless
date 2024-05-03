package faang.school.godbless.sprint3.BJS2_6320;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int score;
    private int lives;
    private boolean isAlive;
}
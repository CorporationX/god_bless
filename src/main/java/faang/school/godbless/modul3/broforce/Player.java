package faang.school.godbless.modul3.broforce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int score;
    private int lives;
    private boolean isAlive;
}

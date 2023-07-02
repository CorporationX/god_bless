package faang.school.godbless.synchronize.broForce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bro {
    private String name;
    private int score;
    private int lives;
    private boolean isAlive;
}

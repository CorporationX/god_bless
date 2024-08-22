package faang.school.godbless.BroForce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Player {
    private String name;
    private int lives;
    private int score;

    public boolean isPlayerSurvived() {
        return new Random().nextBoolean();
    }
}

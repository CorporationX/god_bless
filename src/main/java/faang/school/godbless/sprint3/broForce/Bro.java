package faang.school.godbless.sprint3.broForce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class Bro {
    private String name;
    private int lives;

    public boolean isAlive() {
        return new Random().nextBoolean();
    }
}

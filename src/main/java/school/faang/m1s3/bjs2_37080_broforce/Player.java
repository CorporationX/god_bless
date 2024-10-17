package school.faang.m1s3.bjs2_37080_broforce;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Player {
    private final String name;
    private int lives = 5;
    private int score = 0;

    boolean checkIsInjured() {
        return Math.random() < 0.33;
    }

}

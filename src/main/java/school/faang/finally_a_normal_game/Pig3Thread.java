package school.faang.finally_a_normal_game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf-Naf", "bricks");
    }

    @Override
    public void run() {
        buildHouse(4000);
    }
}

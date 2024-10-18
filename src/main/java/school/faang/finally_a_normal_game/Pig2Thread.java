package school.faang.finally_a_normal_game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf-Nuf", "sticks");
    }

    @Override
    public void run() {
        buildHouse(3000);
    }
}
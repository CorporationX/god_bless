package school.faang.task_61413;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig3Thread extends PigThread {
    public static final int BUILDING_TIME = 6000;

    public Pig3Thread() {
        super("Naf-Naf", "bricks");
    }

    @Override
    public void run() {
        buildHouse(BUILDING_TIME);
    }
}

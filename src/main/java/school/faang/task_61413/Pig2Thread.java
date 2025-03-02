package school.faang.task_61413;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig2Thread extends PigThread {
    public static final int BUILDING_TIME = 4000;

    public Pig2Thread() {
        super("Nuf-Nuf", "sticks");
    }

    @Override
    public void run() {
        buildHouse(BUILDING_TIME);
    }
}

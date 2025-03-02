package school.faang.task_61413;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pig1Thread extends PigThread {
    public static final int BUILDING_TIME = 2000;

    public Pig1Thread() {
        super("Nif-Nif", "straw");
    }

    @Override
    public void run() {
        buildHouse(BUILDING_TIME);
    }
}

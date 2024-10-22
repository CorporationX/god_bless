package school.faang.carry;

import java.util.List;
import java.util.Random;

public class Chest {
    private final static int TIME_TO_WORK = 1000;
    private final static int MAX_POWER = 10;

    private Random random = new Random();
    private List<String> names = List.of("Меч", "Лук", "Щит", "Ружье");

    public Item getItem() {
        try {
            Thread.sleep(TIME_TO_WORK);
            return new Item(
                    names.get(random.nextInt(names.size())),
                    random.nextInt(MAX_POWER));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

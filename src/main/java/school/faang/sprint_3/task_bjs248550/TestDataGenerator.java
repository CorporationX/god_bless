package school.faang.sprint_3.task_bjs248550;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class TestDataGenerator {
    private static final Random RANDOM = new Random();

    public List<String> getRandomChores(int capacity) {
        String[] tasks = {"Wash dishes", "Clean room", "Walk with dog", "laundry"};
        List<String> chores = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            chores.add(tasks[RANDOM.nextInt(0, tasks.length - 1)]);
        }
        return chores;
    }
}

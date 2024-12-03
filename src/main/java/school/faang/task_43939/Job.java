package school.faang.task_43939;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Job {

    public static final List<String> AVAILABLE_JOB = Arrays.asList("UBS", "Google", "Bank of America", "Amazon",
            "Uber", "Yandex", "Sber", "VK", "SwissCom", "Tele 2", "MTS", "Beeline", "LMT", "Swedbank", "SEB");

    static Random random = new Random();

    public static String getRandomJob() {
        return AVAILABLE_JOB.get(random.nextInt(AVAILABLE_JOB.size()));
    }
}

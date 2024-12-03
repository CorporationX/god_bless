package school.faang.task_43939;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Name {

    public static final List<String> AVAILABLE_NAME = Arrays.asList("Sofia", "Victoria", "Ksenia", "Arina", "Yelizaveta", "Adelina", "Irina", "Yelena", "Polina", "Daria", "Natalia", "Svetlana");

    static Random random = new Random();

    public static String getRandomName() {
        return AVAILABLE_NAME.get(random.nextInt(AVAILABLE_NAME.size()));
    }
}

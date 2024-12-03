package school.faang.task_43939;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Address {

    public static final List<String> AVAILABLE_ADDRESS = Arrays.asList("London", "New York", "Amsterdam", "Minsk", "Riga", "Sofia", "Kiev", "Kirov", "Perm", "Tallin", "Berlin", "Paris");

    static Random random = new Random();

    public static String getRandomAddress() {
        return AVAILABLE_ADDRESS.get(random.nextInt(AVAILABLE_ADDRESS.size()));
    }

}

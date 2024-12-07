package school.faang.task_44726;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Amenities {
    private static final List<String> AMENITIES =
            Arrays.asList("TV", "Shower", "Kettle", "Towels",
                    "Double bad", "Kitchen", "Toilet", "Ironing", "Heating", "Oven");

    private static final int NUMBER_OF_AMENITIES = 6;
    static Random random = new Random();

    private static String getRandomAmenity() {
        return AMENITIES.get(random.nextInt(AMENITIES.size()));
    }

    public static Set<String> getSetOfAmenities() {
        Set<String> amenities = new HashSet<>();
        for (int i = 0; i < NUMBER_OF_AMENITIES; i++) {
            amenities.add(getRandomAmenity());
        }
        return amenities;
    }
}



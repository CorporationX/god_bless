package school.faang.task_43972;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Utility {
    static Calendar cal = Calendar.getInstance();
    static Faker faker = new Faker();

    public static String getRandomName() {
        return faker.name().firstName();
    }

    public static int getRandomIntegerWithinRange(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    //here, instead of real hobbies i use colors
    public static Set<String> getListWithActivities() {
        Set<String> activity = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            activity.add(faker.color().name());
        }
        return activity;
    }
}

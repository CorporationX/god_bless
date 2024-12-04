package school.faang.task_43939;

import com.github.javafaker.Faker;

public class Name {

    private static Faker faker = new Faker();

    public static String getRandomName() {
        return faker.name().firstName();
    }
}

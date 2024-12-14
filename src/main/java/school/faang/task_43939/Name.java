package school.faang.task_43939;

import net.datafaker.Faker;

public class Name {

    private static Faker faker = new Faker();

    public static String getRandomName() {
        return faker.name().firstName();
    }
}

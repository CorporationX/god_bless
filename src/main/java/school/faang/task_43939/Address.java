package school.faang.task_43939;

import net.datafaker.Faker;

public class Address {

    private static Faker faker = new Faker();

    public static String getRandomAddress() {
        return faker.address().city();
    }
}

package school.faang.task_43939;

import com.github.javafaker.Faker;

public class Address {

    private static Faker faker = new Faker();

    public static String getRandomAddress() {
        return faker.address().city();
    }
}

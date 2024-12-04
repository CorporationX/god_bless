package school.faang.task_43939;

import com.github.javafaker.Faker;

public class Job {

    private static Faker faker = new Faker();

    public static String getRandomJob() {
        return faker.company().name();
    }
}

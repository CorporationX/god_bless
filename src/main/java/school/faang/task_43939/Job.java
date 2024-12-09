package school.faang.task_43939;

import net.datafaker.Faker;

public class Job {

    private static Faker faker = new Faker();

    public static String getRandomJob() {
        return faker.company().name();
    }
}

package school.faang.fourthStream.BJS2_38792;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class Notification {
    private static final int WORD_COUNT_IN_MESSAGE = 4;

    private final Faker faker = new Faker();
    private final String message;
    private final int id;

    private static int nextId = 1;

    public Notification() {
        this.id = nextId++;
        this.message = faker.lorem().sentence(4);
    }
}

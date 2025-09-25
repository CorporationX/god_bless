package school.faang.sprint3.person.priner;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;


import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.IntStream;


@RequiredArgsConstructor
@ToString
@Getter
public class Person {

    private static final Integer MAX_NAME_SIZE = 5;
    private static final Integer MAX_SURNAME_SIZE = 5;
    private static final Integer MAX_WORKPLACE_SIZE = 10;
    private static final Random random = new Random();

    private final String name;
    private final String surname;
    private final Integer age;
    private final String workplace;


    public Person() {
        this.age = new Random().nextInt(100) + 1;
        this.workplace = generateString(random.nextInt(MAX_WORKPLACE_SIZE) + 1);
        this.surname = generateString(random.nextInt(MAX_SURNAME_SIZE) + 1);
        this.name = generateString(random.nextInt(MAX_NAME_SIZE) + 1);

    }

    private String generateString(Integer length) {
        return RandomStringUtils.secure().nextAlphabetic(length);
    }
}

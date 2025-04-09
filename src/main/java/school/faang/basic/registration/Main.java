package school.faang.basic.registration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        User validUser = new User("Jonny", 18, "Google", "London");
        String validUserMessage = "Корректно созданный пользователь - %s".formatted(validUser);
        String invalidUserMessage = "";
        try {
            new User("  ", 17, "Yandex", "Moscow");
        } catch (IllegalArgumentException e) {
            invalidUserMessage = e.getMessage();
        }

        log.info(validUserMessage);
        log.info(invalidUserMessage);
    }
}

package school.faang.bjs2_68202;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        String validUserMessage = "Корректно созданный пользователь - %s".formatted( new User("Jonny", 18, "Google", "London"));
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

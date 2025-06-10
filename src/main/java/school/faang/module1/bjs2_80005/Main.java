package school.faang.module1.bjs2_80005;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("Важное письмо", "Напоминание о встрече в 15:00 сегодня.", true),
                new Email("Реклама", "Скидки на всё!", false),
                new Email("Спам", "Вы выиграли миллион!", false),
                new Email("Важное уведомление", "Подтвердите вход в аккаунт", true),
                new Email("Важное письмо", "Срочно: обновите пароли для безопасности.", true)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Function<Email, String> addDate = email -> email.getBody() + " " + getCurrentFormattedDate();
        Consumer<Email> printEmail = email -> log.info("Отправлено {}", email);

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, importantFilter, addDate, printEmail);
    }

    private static String getCurrentFormattedDate() {
        return LocalDateTime.now().format(DATE_FORMATTER);
    }
}
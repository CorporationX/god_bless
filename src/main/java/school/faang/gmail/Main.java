package school.faang.gmail;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {
    private static final List<Email> emails = Arrays.asList(
            new Email("Встреча", "Встреча в 15:00", true),
            new Email("Реклама", "Выиграйте миллион!", false),
            new Email("IP адреса", "10.29.140.71 и 10.29.140.72", false),
            new Email("Long Email", "1".repeat(101), false),
            new Email("Cut Email", "2".repeat(100), false),
            new Email("SNMP", "Система дала сбой!", true)
    );

    public static void main(String[] args) {
        EmailProcessor processor = new EmailProcessor();

        processImportantEmails(processor);
        processShortEmails(processor);
        archiveImportantEmails(processor);
    }

    private static void processImportantEmails(EmailProcessor processor) {
        log.info("1. Обработка важных писем:");
        processor.processEmails(
                emails,
                Email::isImportant,
                addPriorityMark(),
                logEmail()
        );
    }

    private static void processShortEmails(EmailProcessor processor) {
        log.info("2. Обработка коротких писем с обрезкой:");
        processor.processEmails(
                emails,
                isShortEmail(),
                truncateLongEmails(),
                logEmail()
        );
    }

    private static void archiveImportantEmails(EmailProcessor processor) {
        log.info("3. Архивация важных писем:");
        processor.processEmails(
                emails,
                Email::isImportant,
                Email::getBody,
                archiveEmail()
        );
    }

    private static Predicate<Email> isShortEmail() {
        return email -> email.getBody().length() <= 100;
    }

    private static Function<Email, String> addPriorityMark() {
        return email -> (email.isImportant() ? "[ВАЖНО] " : "") + email.getBody();
    }

    private static Function<Email, String> truncateLongEmails() {
        return email -> email.getBody().length() > 50
                ? email.getBody().substring(0, 50) + "..."
                : email.getBody();
    }

    private static Consumer<Email> logEmail() {
        return email -> log.info("Обработано: {}", email);
    }

    private static Consumer<Email> archiveEmail() {
        return email -> log.info("Архивировано: {}", email.getSubject());
    }
}

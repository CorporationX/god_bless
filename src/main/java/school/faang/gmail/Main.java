package school.faang.gmail;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class Main {

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Встреча", "Встреча в 15:00", true),
                new Email("Реклама", "Выиграйте миллион!", false),
                new Email("IP адреса", "10.29.140.71 и 10.29.140.72", false),
                new Email("Long Email", "1".repeat(101), false),
                new Email("Cut Email", "2".repeat(100), false),
                new Email("SNMP", "Система дала сбой!", true)
        );

        EmailProcessor processor = new EmailProcessor();

        Predicate<Email> importantFilter = Email::isImportant;
        Predicate<Email> shortBodyFilter = email -> email.getBody().length() <= 100;

        Function<Email, String> addPriorityMark = email ->
                (email.isImportant() ? "[ВАЖНО] " : "") + email.getBody();
        Function<Email, String> truncateLongEmails = email ->
                email.getBody().length() > 50
                        ? email.getBody().substring(0, 50) + "..."
                        : email.getBody();

        Consumer<Email> printEmail = email ->
                log.info("Обработано: {}", email);
        Consumer<Email> archiveEmail = email ->
                log.info("Архивировано: {}", email.getSubject());

        log.info("1. Обработка важных писем:");
        processor.processEmails(emails, importantFilter, addPriorityMark, printEmail);
        log.info("2. Обработка коротких писем с обрезкой:");
        processor.processEmails(emails, shortBodyFilter, truncateLongEmails, printEmail);
        log.info("3. Архивация важных писем:");
        processor.processEmails(emails, importantFilter, Email::getBody, archiveEmail);
    }
}

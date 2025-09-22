package school.faang.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.*;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = List.of(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::getIsImportant;
        Consumer<Email> printEmail = Main::accept;
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        emails.forEach(out::println);
    }

    private static void accept(Email email) {
        out.println("Обработано письмо: " + email.getSubject());
    }
}
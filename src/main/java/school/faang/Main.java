package school.faang;

import school.faang.sprint2.gmail.rich.filters.Email;
import school.faang.sprint2.gmail.rich.filters.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Купите наши волшебные таблетки", false),
                new Email("ВАЖНО!", "Не забудьте о встрече в 15:00", true)
        );

        System.out.println("===Исходные письма===");
        emails.forEach(System.out::println);
        System.out.println();

        Predicate<Email> customFilter = email -> email.isImportant() || email.getSubject().contains("Важно");

        Consumer<Email> loggingConsumer = email -> System.out.println("[LOG] Обработано письмо: '" + email.getSubject() + "'. Важное: " + email.isImportant());

        Function<Email, String> obfuscateTransformer = email -> {
            String body = email.getBody();
            body = body.toUpperCase();
            body = body.replaceAll("[АЕЁИОУЫЭЮЯAEIOUY]", "*");
            return body;
        };

        System.out.println("=== Начинаем обработку===");
        emailProcessor.processEmails(emails, customFilter, loggingConsumer, obfuscateTransformer);
        System.out.println();

        System.out.println("===Письма после обработки===");
        for (Email email : emails) {
            System.out.println("Тема: " + email.getSubject());
            System.out.println("Текст: " + email.getBody());
            System.out.println("---");
        }
    }
}

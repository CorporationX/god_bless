package school.faang.task_45979;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо №1", "   Принесите пожалуйста список научной литературы к докладу   ",
                        true),
                new Email("Письмо №2", "     Please bring a list of scientific literature to the report",
                        true),
                new Email("Спам", "Рассылка sunlight", false)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> isImpotantFilter = (email) -> email.getIsImportant();

        Consumer<Email> bigHeadlineFilter = (email) -> System.out.println("Получено письмо: "
                + email.getSubject());

        Function<Email, String> trimFilterRu = (email) -> { //решение для русской раскладки
            String str = email.getBody();
            email.setBody(str.trim());
            return email.getBody();
        };

        Function<Email, String> trimFilterEn = (email) -> email.getBody().trim().toUpperCase();

        emails.forEach((email) -> System.out.println("Тема: '" + email.getSubject()
                + "' Письмо: " + email.getBody()));

        System.out.println("");

        emailProcessor.processEmails(emails, isImpotantFilter, trimFilterRu, bigHeadlineFilter);

        System.out.println("");

        emails.forEach((email) -> System.out.println("Тема: '" + email.getSubject()
                + "' Письмо: " + email.getBody()));
    }
}

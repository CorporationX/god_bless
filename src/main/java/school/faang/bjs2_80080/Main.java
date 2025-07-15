package school.faang.bjs2_80080;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>() {
            {
                add(new Email("письмо 1", "текст письма 1", false));
                add(new Email("письмо 2", "текст письма 2", true));
                add(new Email("письмо 3", "текст письма 3", true));
                add(new Email("спам", "текст спама", false));
            }};

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо: %s%n", email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emails.forEach(email ->
                System.out.printf("Тема: %s, Тело письма: %s%n", email.getSubject(), email.getBody())
        );
    }
}
package school.faang.bjs2_80080;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("письмо 1", "текст письма 1", false),
                new Email("письмо 2", "текст письма 2", true),
                new Email("письмо 3", "текст письма 3", true),
                new Email("спам", "текст спама", false)
        );


        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody())
        );
    }
}
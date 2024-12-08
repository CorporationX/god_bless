package school.faang.task_45774;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Text 1", false),
                new Email("Email 2", "Text 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Print email: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emails.forEach(System.out::println);
        System.out.println("The result of filters: ");
        List<Email> importantEmails = emailProcessor.predicateList(emails, importantFilter);
        emailProcessor.consumeList(importantEmails, printEmail);
        emailProcessor.functionList(importantEmails, toUpperCase);
    }
}

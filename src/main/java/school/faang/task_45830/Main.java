package school.faang.task_45830;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        try {
            List<Email> emails = Arrays.asList(
                    new Email("Letter from T-bank", "You were refused", false),
                    new Email("Letter from Google", "You are accepted", true),
                    new Email("Spam", "All sorts of nonsense", false)
            );

            Predicate<Email> importantFilter = Email::isImportant;

            Consumer<Email> printEmail = email ->
                    System.out.println("Обработано письмо: " + email.getSubject());

            Function<Email, String> toUpperCase = email -> {
                email.setBody(email.getBody().toUpperCase());
                return email.getBody();
            };

            emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

            emails.forEach(email ->
                    System.out.printf("Тема: %s, Тело письма: %s%n", email.getSubject(), email.getBody()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

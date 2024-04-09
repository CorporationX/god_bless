package gmailRichFilters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> spamEmails = new ArrayList<>();
        List<Email> emails = Arrays.asList(
                new Email("Email 1", "Somthing text", true),
                new Email("Email 2", "Somthing text 2", true),
                new Email("Email 3", "spam", false)
        );


        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        Function<Email, String> toUpperCase = email -> email.getBody().toLowerCase();
        Consumer<Email> printBody = email -> System.out.println(email.getBody());

        emailProcessor.processEmails(emails, importantFilter, printEmail, toLowerCase, printBody);
    }
}

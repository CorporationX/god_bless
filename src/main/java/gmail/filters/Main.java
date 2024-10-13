package gmail.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Spam", "Buy our product for $4 today", false));
        emails.add(new Email("Job offer", "Join to our company!", true));
        emails.add(new Email("LinkedIn notification", "John Doe made a new post!", false));
        emails.add(new Email("Gmail important mail", "Very important text", true));

        Predicate<Email> importantMailFilter = email -> email.isImportant();
        Function<Email, String> toUpperCaseConvertor = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmailSubject = email -> System.out.println(email.getSubject());

        emailProcessor.processEmails(emails, importantMailFilter, toUpperCaseConvertor, printEmailSubject);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + " | Body: " + email.getBody()));
    }
}

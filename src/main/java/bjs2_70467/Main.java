package bjs2_70467;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Mailing", "Which concert should I go to this weekend?", false),
                new Email("Delivery", "Your order has been delivered to the pick-up point!", true),
                new Email("Spam", "Do you want to earn mountains of gold by sitting on the couch and not working? Click here!", false),
                new Email("Payment", "Your tickets are paid!", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Consumer<Email> printEmail = email -> System.out.println("The email has been processed: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody()));
    }
}

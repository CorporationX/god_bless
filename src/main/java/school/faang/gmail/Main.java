package school.faang.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Gosuslugi", "Come to the military registration and enlistment office. We miss you.", false),
                new Email("Sber", "You have been pre-approved for a credit card worth three trillion euros", false),
                new Email("DodoPizza", "Please keep the receipt for your order #345", true),
                new Email("FAANG SCHOOL", "Top 3 Ways to Become a Senior in Mongolia", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Processing the letter: " + email.getSubject());
        Function<Email, String> convertToUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, convertToUpperCase);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + " | Content: " + email.getBody()));
    }
}

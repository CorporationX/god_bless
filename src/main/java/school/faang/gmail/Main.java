package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Important System Update",
                "Don't forget to update your security system to the latest version.", true));
        emails.add(new Email("Payment Reminder", "Your payment invoice expires in 3 days. Please pay on time.",
                true));
        emails.add(new Email("Urgent! Your Card Has Been Blocked",
                " Suspicious activity detected. Confirm your details to avoid being blocked.", false));

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("The email has been processed. " +
                email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getSubject().toUpperCase();
        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", the body of the letter:" +
                email.getBody()));
    }
}

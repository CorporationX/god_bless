package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Welcome", "Welcome to our service!", true));
        emails.add(new Email("Discount", "Get 50% off on your next purchase.", false));
        emails.add(new Email("Spam", "You've won a million dollars!", true));
        emails.add(new Email("Newsletter", "Our latest news and updates.", true));
        emails.add(new Email("Reminder", "Don't forget your appointment tomorrow.", false));


        Predicate<Email> predicate = email -> email.isImportant();
        Function<Email, String> function = email -> {
            email.setBody(email.getBody().toLowerCase());
            return email.getBody();
        };
        Consumer<Email> consumer = email -> System.out.println("Subject: " + email.getSubject() + ", Body: " + email.getBody());

        emailProcessor.processEmails(emails, predicate, function, consumer);




    }
}

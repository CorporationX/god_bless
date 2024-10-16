package school.faang.Lambda.BJS2_33574;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emailList = new ArrayList<>(Arrays.asList(
                new Email("Meeting Reminder", "Don't forget our meeting at 3 PM today.", true),
                new Email("Project Update", "The project is on track for next week's release.", false),
                new Email("Invitation to Webinar", "Join us for an informative webinar on new tech.", true),
                new Email("Discount Offer", "Exclusive 20% discount on your next purchase!", false),
                new Email("Password Reset", "Click here to reset your account password.", true),
                new Email("Weekly Newsletter", "Check out this week's top articles and trends.", false),
                new Email("Event Reminder", "Don't miss our special event this weekend.", true),
                new Email("Subscription Confirmation", "Your subscription has been successfully activated.", false),
                new Email("Security Alert", "Unusual login activity detected on your account.", false),
                new Email("Feedback Request", "We would love to hear your feedback on our service.", false)
        ));

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emailList, importantFilter, printEmail, toUpperCase);

        emailList.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}

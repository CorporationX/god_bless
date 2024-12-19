package school.faang.bjs245862;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Meeting Reminder", "Don't forget about the meeting at 2 PM.", true));
        emails.add(new Email("Newsletter", "Check out our latest news and updates!", false));
        emails.add(new Email("Project Deadline", "The project deadline is approaching. Please submit your work by Friday.", true));
        emails.add(new Email("Spam", "Congratulations! You've won a free trip to the moon!", false));
        emails.add(new Email("Team Lunch", "Join us for a team lunch at the cafeteria at 12 PM.", false));

        Predicate<Email> filterImportance = Email::isImportant;
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        Consumer<Email> print = email -> System.out.println("Message processed: " + email.getBody());

        EmailProcessor processor = new EmailProcessor();
        processor.processEmails(emails, filterImportance, toLowerCase, print);
    }
}

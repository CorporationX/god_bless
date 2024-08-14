package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Password Reset", "You requested to reset your password. Click the link below to proceed.", false),
                new Email("Lunch Tomorrow?", "Are you free for lunch tomorrow? Let me know.", false),
                new Email("Meeting Reminder", "Just a reminder about our meeting scheduled for 3 PM today. See you then!", true),
                new Email("You've Won 1,000,000 Dollars!!!", "Wow! You've just won $1,000,000 in the Totally Real Lottery", false)
        );
        List<Email> spamMail = new ArrayList<>();

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Formatted Email: \n" + email.getSubject() + "\n|__" + email.getBody());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Predicate<Email> spamFilter = email -> {
            String[] keyWords = {"congratulations", "won", "bank", "prize", "scam", "spam"};
            for (String word : keyWords) {
                if (email.getBody().toLowerCase().contains(word)) {
                   return true;
                }
            };
            return false;
        };
        Consumer<Email> printSpamEmail = email -> System.out.println("Sent to spam: \n" + email.getSubject() + "\n|____" + email.getBody());
        Function<Email, String> sendToSpam = email -> {
            spamMail.add(email);
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emailProcessor.processEmails(emails, spamFilter, printSpamEmail, sendToSpam);
    }
}

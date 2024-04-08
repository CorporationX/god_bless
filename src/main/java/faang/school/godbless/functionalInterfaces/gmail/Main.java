package faang.school.godbless.functionalInterfaces.gmail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Job Offer", "We're hiring! Interested? Contact us.", true),
                new Email("Sports Betting", "Win big with our latest offers!", true),
                new Email("Purchase Receipt", "Your receipt for recent purchase.", true),
                new Email("Spam", "You've won! Claim your prize now!", true)
        );

        Predicate<Email> spamFilter = email -> {
            var spamEmails = Arrays.asList(
                    "Buy now and save!",
                    "Congratulations, you've won!",
                    "Click here for free offer",
                    "Limited time offer, act fast!",
                    "You've won!",
                    "Claim your prize now!",
                    "Win big"
            );

            return spamEmails.stream().noneMatch(email.getBody()::contains);
        };

        Consumer<Email> notificationSender = email -> {
            System.out.println("You received new "
                    + email.getImportance()
                    + " email.\nIt's subject is: "
                    + email.getSubject()
                    + "\n");
        };

        Function<Email, Email> dateSetter = email -> {
            var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            var newBody = email.getBody() + " Received at " + LocalDateTime.now().format(formatter);
            return new Email(email.getSubject(), newBody, email.isImportant());
        };

        System.out.println("Processing emails:");

        var processedEmails = emailProcessor.processEmails(emails, spamFilter, notificationSender, dateSetter);

        System.out.println("\n Processed  emails:");

        processedEmails.forEach(System.out::println);
    }
}

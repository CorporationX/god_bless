package school.faang.task_45793;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = addEmails();

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Message processed: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        emails.forEach(email -> System.out.println("Subject: " + email.getSubject() + ", Email body: " + email.getBody()));
    }

    private static List<Email> addEmails() {
        List<Email> emails = new ArrayList<>();

        emails.add(new Email("Kafka", "Please update kafka on the server", false));
        emails.add(new Email("Java", "Please update Java on the server", true));
        emails.add(new Email("Spam", "You won 10000000$!", false));
        return emails;
    }
}

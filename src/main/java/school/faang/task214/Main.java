package school.faang.task214;

import school.faang.task214.Emails.Email;
import school.faang.task214.Emails.EmailProcessor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Email firstEmail = new Email("mail 1", "mail body 1", true);
        Email secondEmail = new Email("mail 2", "mail body 2", true);
        Email thirdEmail = new Email("Spam", "Spam", false);

        Predicate<Email> emailFilter = (email) -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Message processed: " + email.getSubject());
        Function<Email, String> emailChanger = email -> email.getBody().toUpperCase();

        List<Email> emails = List.of(firstEmail, secondEmail, thirdEmail);
        emails.forEach(email -> EmailProcessor.processEmails(email, emailFilter, emailChanger, printEmail));
        emails.forEach(email -> System.out.println("subject: " + email.getSubject() + ", mail body: " + email.getBody()));


    }
}

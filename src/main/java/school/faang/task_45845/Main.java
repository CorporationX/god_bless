package school.faang.task_45845;

import school.faang.task_45845.entity.Email;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Club", "Something stupid", false),
                new Email("Kredit", "Something important", true),
                new Email("Spam", "Text from spam", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;

        Consumer<Email> printEmail = email -> System.out.println("Processed email: "
                + email.getSubject() + "\n Body of Email: " + email.getBody());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Subject: " + email.getSubject()
                + ", \n Body of mail: " + email.getBody() + "\n"));
    }
}

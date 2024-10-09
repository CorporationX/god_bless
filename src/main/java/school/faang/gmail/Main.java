package school.faang.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    List<Email> emails = Arrays.asList(
        new Email("Mail subject 1", "Message 1 text", false),
        new Email("Mail subject 2", "Message 2 text", true),
        new Email("Spam", "Spam text", false),
        new Email("Mail subject 4", "Message 4 text text", true)
    );

    EmailProcessor emailProcessor = new EmailProcessor();

    Predicate<Email> importantFilter = email -> email.isImportant();

    Consumer<Email> printEmail = email -> System.out.println(
        "The processed message: " + email.getSubject());

    Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

    emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

    emails.forEach(email -> System.out.println(
        "Important: " + email.isImportant() + " Subject: " + email.getSubject() + ", Message: "
            + email.getBody()));
  }

}

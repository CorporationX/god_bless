package school.faang.gmail_rich_filters;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        var listEmails = new ArrayList<>(List.of(
                new Email("About working", "Email text 1", false),
                new Email("About studying", "Email text 2", true),
                new Email("Annoying advertising", "Spam", false)));

        Predicate<Email> checkSpam = email -> !email.getSubject().equals("Annoying advertising")
                && email.isImportant();

        Function<Email, String> edite = email -> email.getBody().toUpperCase();

        Consumer<Email> print = email -> System.out.println(MessageFormat.format(
                "EMAIL FOR READING\nSubject: {0}\nBody: {1}\nImportance: {2}\n", email.getSubject(),
                email.getBody(), email.isImportant()));

        EmailProcessor.processEmails(listEmails, checkSpam, edite, print);
    }
}

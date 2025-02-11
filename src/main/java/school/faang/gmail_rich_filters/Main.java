package school.faang.gmail_rich_filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        var listEmails = new ArrayList<>(List.of(new Email("About working", "Email text 1", false),
                new Email("About studying", "Email text 2", true),
                new Email("Annoying advertising", "Spam", false)));

        Predicate<Email> isSpam = email -> !email.getSubject().equals("Annoying advertising")
                && email.isImportant();

        Function<Email, String> editedEmail = email -> email.getBody().toUpperCase();

        Consumer<Email> forReading = email -> email.setSubject("Email for reading - "
                + "\"" + email.getSubject() + "\"" + "\n");

        var resultList = EmailProcessor.processEmails(listEmails, isSpam, editedEmail, forReading);

        resultList.forEach(email -> System.out.println(new StringBuilder("Subject: ")
                .append(email.getSubject())
                .append("Body: ").append(email.getBody()).append("\n")
                .append("Importance: ").append(email.isImportant())));
    }
}

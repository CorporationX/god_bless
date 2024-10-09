package school.faang.gmail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static Predicate<Email> emailFilter = email -> !email.isImportant();
    public static Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
    public static Consumer<Email> showEmailSubject = email -> System.out.println("Обработано письмо от " + email.getSubject());

    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("FaangShool", "Stream 7 is started", true),
                new Email("LinkedIn", "Your profile is cool", false),
                new Email("Google", "some body", false),
                new Email("Avito", "You have a massage", true)
        ));

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emails, emailFilter, toUpperCase, showEmailSubject);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}

package gmailfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("тема 1", "текст/содержание 1", false));
        emails.add(new Email("тема 2", "текст/содержание 2", true));
        emails.add(new Email("тема 3", "текст/содержание 3", true));

        Predicate<Email> filter = email -> email.isImportant();
        Function<Email, String> converter = email -> email.getBody() + " преобразовано";
        Consumer<Email> handler = email -> System.out.println("Обработано письмо: " + email.getSubject()
                + ", " + email.getBody());

        emailProcessor.processEmails(emails, filter, converter, handler);
    }
}

package school.faang.sprint1.sprint2.task_45968;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Письмо 1", "Текст письма 1", false));
        emails.add(new Email("Письмо 2", "Текст письма 2", true));
        emails.add(new Email("Спам", "Текст спама", false));

        Predicate<Email> important = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Письмо обработано " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, important, printEmail, toUpperCase);
        emails.forEach(email -> System.out.println("Тема письма - " + email.getSubject()
                + " Текст письма - " + email.getBody()));

    }
}

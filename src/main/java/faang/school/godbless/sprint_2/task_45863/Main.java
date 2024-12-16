package faang.school.godbless.sprint_2.task_45863;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Письмо 1", "Текст письма 1", false));
        emails.add(new Email("Письмо 2", "Текст письма 2", true));
        emails.add(new Email("Спам", "Текст спама", false));

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> filterImportantEmails = Email::isImportant;

        Function<Email, String> insertSignatureIntoLetter = email -> {
            return email.getBody() + " С уважением, Александр Иванов";
        };

        Consumer<Email> printEmail = email -> System.out.println("Письмо обработано: " + email.getSubject());

        emailProcessor.processEmails(emails, filterImportantEmails, insertSignatureIntoLetter, printEmail);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject()
                + ", Тело письма: " + email.getBody()));
    }
}

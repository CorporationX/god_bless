package school.faang.sprint_1.task_gmailrichfiltersbjs2n45878;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GmailMain {
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Тема 1", "Текст письма 1", false),
                new Email("Тема 2", "Текст важного письма 2", true),
                new Email("Спам", "Текст спама ", false),
                new Email("", "Купите новый телевизор в Эльдварады", false)
        );
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.printf("Обработано письмо c темой: %s\n", email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println("Результат обработки писем:");
        emails.forEach(email -> System.out.printf("Тема: %s, Тело письма: %s \n",
                email.getSubject(), email.getBody()));
    }
}

package school.faang.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {


        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() +
                ", Тело письма: " + email.getBody()));

        Predicate<Email> noImportantFilter = email -> !email.isImportant();
        printEmail = email -> System.out.println("Можно не отвечать: " + email.getSubject());
        Function<Email, String> toLowerCase = email -> email.getBody().toLowerCase();
        emailProcessor.processEmails(emails, noImportantFilter, toLowerCase, printEmail);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() +
                ", Тело письма: " + email.getBody()));

        Predicate<Email> spam = email -> email.getSubject() == "Спам";
        printEmail = email -> System.out.println("Удалить: " + email.getSubject());
        Function<Email, String> erase = email -> "--------------------------";
        emailProcessor.processEmails(emails, spam, erase, printEmail);
        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() +
                ", Тело письма: " + email.getBody()));
    }
}
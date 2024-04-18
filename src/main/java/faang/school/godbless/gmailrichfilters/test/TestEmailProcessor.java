package faang.school.godbless.gmailrichfilters.test;

import faang.school.godbless.gmailrichfilters.Email;
import faang.school.godbless.gmailrichfilters.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestEmailProcessor {
    public static void testProcessEmails() {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Письмо 3", "Текст письма 3", true),
                new Email("Письмо 4", "Текст письма 4", true),
                new Email("Письмо 5", "Текст письма 5", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        List<String> bodies = emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        bodies.forEach(str -> System.out.printf("\t\t\tBody of an email:\t%s \n", str));
    }

    public static void main(String[] args) {
        testProcessEmails();
    }
}

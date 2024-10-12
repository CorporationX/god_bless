package school.faang;

import school.faang.email.services.Email;
import school.faang.email.services.EmailProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Work", "Why aren't u here yet?", true),
                new Email("Stuff", "Lol dude, just check this", false),
                new Email("Family", "You're going to be a father.", true),
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> importantFilter = email -> email.isImpotant();
        Consumer<Email> printEmail = email ->
                System.out.println("Обработано письмо: " + email.getSubject());

        System.out.println("==================");

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        System.out.println("==================");

        emails.forEach(email -> System.out.println(
                "Тема: " + email.getSubject() +
                ", Тело письма: " + email.getBody()
        ));
    }
}

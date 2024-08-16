package faang.school.godbless.GMail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> isImportant = Email::isImportant;
        Consumer<Email> printEmail = System.out::println;
        Function<Email, String> setLowerCase = email -> email.getBody().toLowerCase();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        emailProcessor.processEmails(emails, isImportant, printEmail, setLowerCase);
    }
}

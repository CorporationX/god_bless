package school.faang.bjs2_80070;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("ds1 ", "дс1 по скидке покупай и страдай", true),
                new Email("ds2 ", "дс2 топ игра", false),
                new Email("ds3 ", "дс3 для казуалов", true)
        );
        Predicate<Email> emailFilter = email -> email.isImportant();

        Consumer<Email> emailHandler = email -> System.out.printf("обработанные письма: %s%n",
                email.getSubject());

        Function<Email, String> transformEmail = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, emailFilter, transformEmail, emailHandler);

        emails.forEach(email -> System.out.printf("НЕОТФИЛЬТРОВАННЫЕ ПИСЬМА:%n  тема письма: %s%n    " +
                "  тело письма: %s%n", email.getSubject(), email.getBody()));
        for (Email email : emails) {
            if (email.isImportant()) {
                System.out.printf("ОТФИЛЬТРОВАННЫЕ ПИСЬМА:%n  тема письма: %s%n      тело письма: %s%n",
                        email.getSubject(), email.getBody());
            }
        }
    }
}

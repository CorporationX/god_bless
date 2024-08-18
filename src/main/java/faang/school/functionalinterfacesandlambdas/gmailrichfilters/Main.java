package faang.school.functionalinterfacesandlambdas.gmailrichfilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Text message 1", false),
                new Email("Письмо 2", "Text message 2", true),
                new Email("Спам", "Text spam", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

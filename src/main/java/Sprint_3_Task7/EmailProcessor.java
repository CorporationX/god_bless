package Sprint_3_Task7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> incomingMail, Predicate<Email> emailFiltering, Consumer<Email> letterProcessing, Function<Email, String> letterConversion) {
        for (Email email : incomingMail) {
            if (emailFiltering.test(email)) {
                String result = letterConversion.apply(email);
                email.setBody(result);
                letterProcessing.accept(email);
            }
        }
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getBody());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

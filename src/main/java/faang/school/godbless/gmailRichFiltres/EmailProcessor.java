package faang.school.godbless.gmailRichFiltres;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EmailProcessor {

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
        emails.forEach(System.out::println);
    }

    private void processEmails(List<Email> emails, Predicate<Email> filtration, Consumer<Email> processing, Function<Email, String> transformation) {
        for (Email email : emails) {
            if (filtration.test(email)){
                String body = transformation.apply(email);
                email.setBody(body);
                processing.accept(email);
            }
        }

       /* Consumer<Email> consumer = (email) -> {
            filtration.test(email);
            processing.accept(email);
            transformation.apply(email);
        };
        emails.stream(email -> e);

        */
    }
}

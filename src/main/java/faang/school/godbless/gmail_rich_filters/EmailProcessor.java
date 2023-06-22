package faang.school.godbless.gmail_rich_filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
        if(emails == null || emails.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
        for(Email email : emails) {
            if(predicate.test(email)) {
                String temp = function.apply(email);
                email.setBody(temp);
                consumer.accept(email);
            }
        }
    }

    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "text of message 2", true),
                new Email("Спам", "Текст спама", false)
        );

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> importantFilter = email -> email.getIsImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject() + " - " + email.getBody());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

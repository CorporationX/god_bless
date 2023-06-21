package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> list = List.of(
                new Email("#1", "text 1", false),
                new Email("#2", "text 2", true),
                new Email("#3", "text 3", false)
        );

        Predicate<Email> filter = Email::isImportant;
        
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        Function<Email, String> reverse = email -> {
            return new StringBuilder(email.getBody()).reverse().toString();
        };

        EmailProcessor processor = new EmailProcessor();

        processor.processorEmails(list, filter, printEmail, toUpperCase);
        processor.processorEmails(list, filter, printEmail, reverse);

        for (Email email : list) {
            System.out.println(email.getBody());
        }
    }
}

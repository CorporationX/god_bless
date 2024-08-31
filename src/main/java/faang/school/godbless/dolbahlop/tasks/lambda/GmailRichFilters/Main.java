package faang.school.godbless.dolbahlop.tasks.lambda.GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Text of letter 1", false),
                new Email("Letter 2", "Text of letter 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо:" + email.getSubject());
        Function<Email, Email> toUpperCase = email -> new Email(email.getSubject(), email.getBody().toUpperCase(), email.isImportant());

        List<Email> processedEmails = emailProcessor.processEmail(emails, importantFilter, printEmail, toUpperCase);

        processedEmails.forEach(email -> System.out.println("Преобразованное письмо: " + email.getBody()));
    }
}

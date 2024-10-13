package faang.school.godbless.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> listEmail, Predicate<Email> predicate, Function<Email, String> function, Consumer<Email> consumer) {
        for (Email email : listEmail) {
            if (predicate.test(email)) {
                email.setBody(function.apply(email));
                consumer.accept(email);
            }
        }
        return listEmail;
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Letter 1", "Letter text 1", false),
                new Email("Letter 2", "Letter text 2", true),
                new Email("Spam", "Spam text", false)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        emailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);

        emails.forEach(email -> System.out.println("Вывод Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}

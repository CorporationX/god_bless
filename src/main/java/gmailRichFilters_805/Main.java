package gmailRichFilters_805;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static List<Email> emails = new ArrayList<>();

    public static void main(String[] args) {
        emails = Arrays.asList(new Email("Собрание", "Состоится 15.12", true),
                new Email("Извещение", "Пришла посылка", false),
                new Email("Спам", "Реклама..", false),
                new Email("Напоминание", "Важно..", true)
        );

        Predicate<Email> checkImportant = (email) -> email.isImportant();
        Consumer<Email> notification = (email) -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, Email> editEmailBody = (email) -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.isImportant(emails, checkImportant, notification, editEmailBody);

        System.out.println(emails.toString());
    }
}
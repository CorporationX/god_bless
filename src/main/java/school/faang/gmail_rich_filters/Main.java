package school.faang.gmail_rich_filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        // Список входящих писем
        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        ));

        Function<Email, String> printImportantLettersTheme = email -> {
            if (email.isImportant()) {
                return "Important letter: " + email.getSubject() + "\n";
            }
            return "";
        };

        EmailProcessor emailProcessor1 = new EmailProcessor();
        emailProcessor1.processEmails(emails, mail -> Objects.equals(mail.getSubject(),
                "Спам"), printImportantLettersTheme, mail -> mail.setSubject(mail.getSubject().toUpperCase()));
    }
}

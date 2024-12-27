package gmail_rich_filters;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        List<Email> ImportantEmails = emailProcessor.processEmails(emails);
        emailProcessor.printEmails(ImportantEmails);
    }
}

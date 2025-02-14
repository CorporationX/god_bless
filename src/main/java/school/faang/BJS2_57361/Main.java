package school.faang.BJS2_57361;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmailProcessor processor = new EmailProcessor();
        Email email1 = new Email("Письмо 1", "Текст письма 1", false);
        Email email2 = new Email("Письмо 2", "Текст письма 2", true);
        Email email3 = new Email("Спам", "Текст спама", false);
        List<Email> emails = Arrays.asList(email1, email2, email3);
        processor.setFilter(Email::isImportant);
        processor.setConverter(email -> email.getSubject().toUpperCase());
        processor.setHandler(email -> System.out.printf("%s - %s\n", email.getSubject(), email.getBody()));
        processor.processEmails(emails);
        System.out.println("-------------------");
        processor.setFilter(email -> !email.getSubject().equals("Спам"));
        processor.processEmails(emails);
    }
}

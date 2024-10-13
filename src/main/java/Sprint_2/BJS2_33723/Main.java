package Sprint_2.BJS2_33723;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1 ", "Текст письма 1", false),
                new Email("Письмо 2 ", "Текст письма 2 ", true),
                new Email("Письмо 3 ", "Текст письма 3", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email.getBody();
        };

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

    }
}

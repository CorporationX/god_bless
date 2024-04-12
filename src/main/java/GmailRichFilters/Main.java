package GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProccesor emailProccesor = new EmailProccesor();

        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "текст", true),
                new Email("Письмо 2", "текст", false),
                new Email("Письмо 3", "текст", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProccesor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

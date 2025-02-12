package school.faang.task57399.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "обычный спам", false),
                new Email("Письмо 2", "спасите пожалуйста", true),
                new Email("Письмо 3", "помогите срочно", true)
        );
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Predicate<Email> importantFilter = (Email email) -> email.isImportant();

        List<Email> importantEmails = emailProcessor.processEmails(emails, importantFilter);
        for (Email email : importantEmails) {
            System.out.println("Важное: " + email.getBody());
        }
        System.out.println();
        Predicate<Email> notImportantFilter = (Email email) -> !email.isImportant();
        List<Email> notImportantEmails = emailProcessor.processEmails(emails, notImportantFilter);
        for (Email email : notImportantEmails) {
            printEmail.accept(email);
            System.out.println("Не важное: " + email.getBody());

        }


    }
}

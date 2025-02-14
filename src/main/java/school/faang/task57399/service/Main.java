package school.faang.task57399.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                Email.builder().subject("Письмо 1").body("обычный спам").isImportant(false).build(),
                Email.builder().subject("Письмо 2").body("спасите пожалуйста").isImportant(true).build(),
                Email.builder().subject("Письмо 3").body("помогите срочно").isImportant(true).build()
        );
        Consumer<Email> printEmail = email -> System.out.println(String.format("Обработано письмо: %s", email.getSubject()));
        Predicate<Email> importantFilter = (Email email) -> email.isImportant();

        List<Email> importantEmails = emailProcessor.processEmails(emails, importantFilter);
        for (Email email : importantEmails) {
            System.out.println(String.format("Важное: %s", email.getBody()));
        }
        System.out.println();
        Predicate<Email> notImportantFilter = (Email email) -> !email.isImportant();
        List<Email> notImportantEmails = emailProcessor.processEmails(emails, notImportantFilter);
        for (Email email : notImportantEmails) {
            printEmail.accept(email);
            System.out.println(String.format("Не важное: %s", email.getBody()));
        }
    }
}

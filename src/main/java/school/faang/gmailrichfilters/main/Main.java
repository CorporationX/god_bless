package school.faang.gmailrichfilters.main;

import school.faang.gmailrichfilters.maincode.Email;
import school.faang.gmailrichfilters.maincode.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("тренировка", "анжумания", false),
                new Email("учеба", "читать", true),
                new Email("безделье", "игрушка дьявола", true)
        );

        Predicate<Email> filterEmail = Email::getIsImportant;

        Consumer<Email> printEmail = System.out::println;

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmail(emails, filterEmail, printEmail, toUpperCase);

        emails.forEach(email ->
                System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}
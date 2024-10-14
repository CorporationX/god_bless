package school.faang.bjs2_33737;

import school.faang.bjs2_33737.model.Email;
import school.faang.bjs2_33737.sevice.EmailProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = Arrays.asList(
                new Email("Welcome Letter", "Welcome to our service! We're glad to have you.", true),
                new Email("Password Reset", "Click here to reset your password.", false),
                new Email("Promotion", "Get 50% off on your next purchase!", true),
                new Email("Newsletter", "Here is your weekly newsletter with the latest updates.", true),
                new Email("Spam Alert", "You've won a million dollars! Claim your prize now!", false)
        );
        Predicate<Email> emailFilter = Email::isImportant;
        Function<Email, String> emailUpdateBody = email -> email.getBody() + " UPDATE BODY";
        Consumer<Email> processedEmail = email -> System.out.println("update: " + email);
        emailProcessor.processEmails(emails,emailFilter,emailUpdateBody,processedEmail);

        emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}

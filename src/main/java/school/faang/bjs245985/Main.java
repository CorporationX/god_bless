package school.faang.bjs245985;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailPrcessor emailPrcessor = new EmailPrcessor();

        List<Email> emails = Arrays.asList(
                new Email("Subject1", "Body1", true),
                new Email("Subject2", "Body2", false),
                new Email("Subject3", "Body3", true),
                new Email("Subject4", "Body4", false),
                new Email("Subject5", "Body5", true),
                new Email("Subject6", "Body6", false),
                new Email("Subject7", "Body7", true),
                new Email("Subject8", "Body8", false),
                new Email("Subject9", "Body9", true),
                new Email("Subject10", "Body10", false)
        );

        Predicate<Email> emailFilterIsImportant = Email::isImportant;
        Function<Email, String> emailTransformerToLowerCase = email -> email.getBody().toLowerCase();
        Consumer<Email> printSubject = email -> System.out.printf("Email processed %s \n", email.getSubject());

        emailPrcessor.processEmails(emails, emailFilterIsImportant, emailTransformerToLowerCase, printSubject);

    }
}
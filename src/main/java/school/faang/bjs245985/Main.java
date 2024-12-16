package school.faang.bjs245985;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmailPrcessor emailPrcessor = new EmailPrcessor();

        List<Email> emails = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            emails.add(new Email("Subject" + i, "Body" + i, i % 2 == 1));
        }

        Predicate<Email> emailFilterIsImportant = Email::isImportant;
        Function<Email, String> emailTransformerToLowerCase = email -> email.getBody().toLowerCase();
        Consumer<Email> printSubject = email -> System.out.printf("Email processed %s \n\n", email.getSubject());

        emailPrcessor.processEmails(emails, emailFilterIsImportant, emailTransformerToLowerCase, printSubject);

    }
}
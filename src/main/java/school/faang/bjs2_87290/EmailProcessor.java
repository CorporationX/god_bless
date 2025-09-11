package school.faang.bjs2_87290;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importantFilter,
                              Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        Predicate<Email> emailPredicate = email -> email.isImportant;

        Function<Email, String> emailFunction = email -> email.getBody().toUpperCase();

        Consumer<Email> emailConsumer = email -> System.out.println(email.getSubject());

        emails.stream()
                .filter(emailPredicate)
                .peek(emailConsumer)
                .forEach(email -> {
                    String newBody = emailFunction.apply(email);
                    email.setBody(newBody);
                });
    }
}

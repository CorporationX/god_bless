package school.faang.bjs2_70440;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> importanceChecker, Function<Email, String> changer,
                              Consumer<Email> emailMetamorpher) {
        emails.forEach(email -> {
            emailMetamorpher.accept(email);
            if (importanceChecker.test(email)) {
                System.out.printf("Email about %s is important!\n", email.getSubject());
                String importantMessage = changer.apply(email);
                System.out.println(importantMessage);
            } else {
                System.out.println(email.getBody());
            }
        });
    }
}

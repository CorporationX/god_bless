package faang.school.godbless.javalambda.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> emailPredicate,
                              Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {
        List<Email> emailListResult = new ArrayList<>();
        for (Email email : emails) {
            if (emailPredicate.test(email)) {
                emailListResult.add(email);
            }
            emailConsumer.accept(email);
            email.setBody(emailFunction.apply(email));
        }
        return emailListResult;
    }
}

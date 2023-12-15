package faang.school.godbless.BJS2_793;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Consumer<Email> emailAction, Function<Email, String> emailTransformer) {
        emails.stream().filter(emailFilter).forEach(email -> {
            emailAction.accept(email);
            System.out.printf(String.format("Email %s after transformation: %s"
                    , email, emailTransformer.apply(email)));
        });
    }
}
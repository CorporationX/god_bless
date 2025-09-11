package school.faang.bjs2_90895;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessorFinal implements EmailProcessor {

    @Override
    public void processEmailsWithString(List<Email> emails,
                                       Predicate<Email> filter,
                                       Function<Email, String> transformer,
                                       Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformedText = transformer.apply(email);
                email.setBody(transformedText);
                action.accept(email);
            }
        }
    }

    @Override
    public void processEmailsWithEmail(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, Email> transformer,
                              Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                Email tramsformedEmail = transformer.apply(email);
                action.accept(tramsformedEmail);
            }
        }
    }
}
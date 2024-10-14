package school.faang.bjs2_33737.sevice;

import school.faang.bjs2_33737.model.Email;
import school.faang.bjs2_33737.model.ValidatorEmailProcessor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private final ValidatorEmailProcessor validator = new ValidatorEmailProcessor();

    public void processEmails(List<Email> emails, Predicate<Email> emailFilter, Function<Email, String> emailBodyTransformer,
                              Consumer<Email> emailProcessor) {

        validator.validateProcessEmails(emails, emailFilter, emailBodyTransformer, emailProcessor);
        for (Email email : emails) {
            if (email == null) {
                continue;
            }
            if (emailFilter.test(email)) {
                String transformBody = emailBodyTransformer.apply(email);
                email.setBody(transformBody);
                emailProcessor.accept(email);
            }
        }
    }

}

package school.faang.task45761;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> transformBody,
                              Consumer<Email> processEmail) {

        validate(emails, filter, transformBody, processEmail);

        for (int i = 0; i < emails.size(); i++) {
            Email email = emails.get(i);

            if (email == null || !filter.test(email)) {
                emails.remove(i);
                i--;
            } else {
                String body = transformBody.apply(email);
                email.setBody(body);
                transformBody.apply(email);
                processEmail.accept(email);
            }

        }
    }

    private void validate(List<Email> emails,
                          Predicate<Email> filter,
                          Function<Email, String> transformBody,
                          Consumer<Email> processEmail) {

        if (emails == null) {
            throw new IllegalArgumentException("Emails cannot be null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Filter cannot be null");
        }
        if (transformBody == null) {
            throw new IllegalArgumentException("Transform body cannot be null");
        }
        if (processEmail == null) {
            throw new IllegalArgumentException("Process email cannot be null");
        }
    }

}

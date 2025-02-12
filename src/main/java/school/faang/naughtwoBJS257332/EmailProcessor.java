package school.faang.naughtwoBJS257332;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> action, Function<Email, String> transformer) {
        checkEmailList(emails);
        checkFilter(filter);
        checkAction(action);
        checkTransformer(transformer);
        for (Email email : emails) {
            if (filter.test(email)) {
                String transformerBody = transformer.apply(email);
                email.setBody(transformerBody);
                action.accept(email);
            }
        }
    }

    private void checkEmailList(List<Email> emails) {
        if (emails == null || emails.isEmpty()) {
            throw new IllegalArgumentException("List of emails cannot be 'null' or empty.");
        }
    }

    private void checkFilter(Predicate<Email> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Filter cannot be 'null'.");
        }
    }

    private void checkAction(Consumer<Email> action) {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be 'null'.");
        }
    }

    private void checkTransformer(Function<Email, String> transformer) {
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer cannot be 'null'.");
        }
    }

}

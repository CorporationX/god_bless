package school.faang.naughtwoBJS257332;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> action, Function<Email, String> transformer) {
        checkObject(emails);
        checkObject(filter);
        checkObject(transformer);
        checkObject(action);
        for (Email email : emails) {
            if (filter.test(email)){
                String transformerBody = transformer.apply(email);
                email.setBody(transformerBody);
                action.accept(email);
            }
        }

    }

    private void checkObject(Object o) { //я могу сделать так, вместо отдельных проверок на null?
        // Мне же по сути ничего не надо возвращать, только взять какое то значение и проверить на null
        if (o == null) {
            throw new IllegalArgumentException("Value cannot be 'null'.");
        }
    }

}

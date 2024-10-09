package bjs2_33391;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> messages, Predicate<Email> filter,
                             Function<Email, String> transformBody, Consumer<Email> process) {

        for (int i = 0; i < messages.size(); i++) {
            Email message = messages.get(i);

            if (filter.test(message)) {
                messages.remove(i);
            }
            message.setBody(transformBody.apply(message));
            process.accept(message);
        }
    }
}

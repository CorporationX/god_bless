package ru.kraiush.BJS2_33560;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> emails, Predicate<Email> filter, Function<Email, String> converter, Consumer<Email> handler) {
        for (Email email : emails) {
            filter.test(email);
            String convertedEmailBody = converter.apply(email);
            email.setBody(convertedEmailBody);
            handler.accept(email);
        }
    }
}

package com.functional.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> processing,
                              Function<Email, String> transformations) {
        if (emails == null) {
            return;
        }
        for (Email email : emails) {
            if (filter.test(email)) {
                email.setBody(transformations.apply(email));
                processing.accept(email);
                System.out.println(email.getBody());
            }
        }
    }
}

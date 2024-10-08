package school.faang.m1s2.bjs2_33546_gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> printer,
                              Function<Email, String> fontModifier) {
        for (Email email : emails) {
            if (filter.test(email)) {
                String modifiedText = fontModifier.apply(email);
                email.setBody(modifiedText);
                printer.accept(email);
            }
        }
    }
}





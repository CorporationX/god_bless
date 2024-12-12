package derschrank.sprint02.task04.bjstwo_45769;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> emailFilter,
                              Function<Email, String> emailConvert,
                              Consumer<Email> emailAction) {
        for (Email email : emails) {
            if (emailFilter == null) {
                continue;
            }
            if (emailFilter.test(email)) {
                System.out.println("Convert: " + emailConvert.apply(email));
                emailAction.accept(email);
            }
        }
    }
}

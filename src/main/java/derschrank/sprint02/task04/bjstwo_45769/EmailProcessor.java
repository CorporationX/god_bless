package derschrank.sprint02.task04.bjstwo_45769;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Function<Email, String> convert,
                              Consumer<Email> whatWithEmailToDo) {
        for (Email email : emails) {
            if (filter.test(email)) {
                System.out.println("Convert: " + convert.apply(email));
                whatWithEmailToDo.accept(email);
            }
        }
    }
}

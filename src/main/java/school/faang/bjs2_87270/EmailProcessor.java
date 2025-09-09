package school.faang.bjs2_87270;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    private EmailProcessor() {

    }

    public static void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> processor,
                                            Function<Email, Email> converter) {
        for (int i = 0; i < emails.size(); i++) {
            Email eachEmail = emails.get(i);
            if (filter.test(eachEmail)) {
                processor.accept(eachEmail);
                emails.set(i, converter.apply(eachEmail));
            }
        }
    }
}

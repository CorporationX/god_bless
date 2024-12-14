package faang.school.godbless.BJS2_9388;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> transformer) {
        if (emails == null || emails.isEmpty()) {
            System.out.println("nothing to process");
        } else {
            emails.stream()
                    .filter(filter)
                    .peek(handler)
                    .map(transformer)
                    .toArray();
        }
    }
}

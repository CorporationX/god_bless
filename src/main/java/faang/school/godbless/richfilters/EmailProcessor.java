package faang.school.godbless.richfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> processor,
                              Function<Email, String> transformer) {
        List<String> sortedEmails = emails.stream()
                .filter(filter)
                .peek(processor)
                .map(transformer)
                .toList();

    }
}

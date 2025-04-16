package school.faang.stream2.gmailrichfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> incoming,
                              Predicate<Email> filter,
                              Consumer<Email> transform,
                              Function<Email, String> process) {

    }
}

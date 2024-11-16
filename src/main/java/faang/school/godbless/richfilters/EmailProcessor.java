package faang.school.godbless.richfilters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email,Email> transform){
        List<Email> filteredEmails =emails.stream().filter(filter::test).toList();
        filteredEmails = filteredEmails.stream().map(transform::apply).toList();
        filteredEmails.forEach(handler);
    }
}

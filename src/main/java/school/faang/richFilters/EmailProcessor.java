package school.faang.richFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> emailPredicate,  Consumer<Email> emailConsumer, Function<Email, String> toUpperCase){
        emails.stream().filter(emailPredicate).peek(e-> e.setBody(toUpperCase.apply(e))).forEach(emailConsumer);
    }
}

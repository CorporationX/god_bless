package faang.school.godbless.gamail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails,
                              Predicate<Email> predicate,
                              Consumer<Email> consumer,
                              Function<Email,String> function){
        for(Email email : emails){
            predicate.test(email);
            consumer.accept(email);
            function.apply(email);
        }
    }
}

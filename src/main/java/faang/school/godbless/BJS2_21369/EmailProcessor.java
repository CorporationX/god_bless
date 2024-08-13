package faang.school.godbless.BJS2_21369;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate filter, Consumer processor, Function converter) {
        for (Email email : emails) {
            if (filter.test(email)) {
                processor.accept(email);
                System.out.println(converter.apply(email));
            }
        }
    }
}


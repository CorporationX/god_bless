package school.faang.bjs245812;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public <R> List<R> processEmails(List<Email> emails,
                                     Predicate<Email> predicate,
                                     Consumer<Email> consumer,
                                     Function<Email, R> act) {

        if (CollectionUtils.isEmpty(emails)) {
            throw new IllegalArgumentException("Emails not found !!!");
        }

        List<R> resultEmails = new ArrayList<>();

        for (Email email : emails) {
            if (predicate.test(email)) {
                consumer.accept(email);
                R result = act.apply(email);
                resultEmails.add(result);
            }
        }
        return resultEmails;
    }
}

package gmail_rich_filter_33710;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


@NoArgsConstructor
public class EmailProcessor {
    public void processEmails(List<Email> emails,
                                     Predicate<Email> predicate,
                                     Consumer<Email> consumer,
                                     Function<Email, String> function) {

        emails.stream().filter(predicate)
                .forEach(consumer
                        .andThen(email -> email.setBody(function.apply(email))));

    }
}

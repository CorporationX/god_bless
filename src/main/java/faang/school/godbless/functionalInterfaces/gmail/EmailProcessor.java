package faang.school.godbless.functionalInterfaces.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails,
                                     Predicate<Email> filter,
                                     Consumer<Email> processor,
                                     Function<Email, Email> transformer) {

        return emails.stream().map(email -> {
            var processedEmail = transformer.apply(email);
            processedEmail.setImportant(filter.test(email));
            processor.accept(email);

            return processedEmail;
        }).toList();
    }
}

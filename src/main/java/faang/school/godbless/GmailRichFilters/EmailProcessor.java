package faang.school.godbless.GmailRichFilters;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> emailPredicate, Consumer<Email> emailConsumer, Function<Email, String> emailFunction) {
        if (Objects.isNull(emailList)) {
            throw new IllegalArgumentException("List is empty");
        }
        for (Email email : emailList) {
            if (emailPredicate.test(email)) {
                emailConsumer.accept(new Email(email.getSubject(), emailFunction.apply(email), email.getIsImportant()));
            }
        }
    }
}

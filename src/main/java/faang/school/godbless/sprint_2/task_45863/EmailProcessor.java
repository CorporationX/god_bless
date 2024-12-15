package faang.school.godbless.sprint_2.task_45863;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> convert,
                              Consumer<Email> process) {

        Optional<List<Email>> optionalEmails = Optional.ofNullable(emails);

        List<Email> emailList = optionalEmails.orElseThrow(
                () -> new IllegalArgumentException("Список писем не может быть пустым!")
        );

        Iterator<Email> emailIterator = emailList.iterator();
        while (emailIterator.hasNext()) {
            Email email = emailIterator.next();
            if (filter.test(email)) {
                email.setBody(convert.apply(email));
                process.accept(email);
            } else {
                emailIterator.remove();
            }
        }
    }
}

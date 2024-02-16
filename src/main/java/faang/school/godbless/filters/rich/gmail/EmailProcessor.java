package faang.school.godbless.filters.rich.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> mails, Predicate<Email> importantMakr, Consumer<Email> consumer, Function<Email, String> function) {
        List<Email> filteredMails = new ArrayList<>();
        for (Email mail : mails) {
            if (importantMakr.test(mail)) filteredMails.add(mail);
            function.apply(mail);
            consumer.accept(mail);
            }
        filteredMails.forEach(item -> System.out.println(item.toString()));
    }
}

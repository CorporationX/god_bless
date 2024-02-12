package faang.school.godbless.GMailRichFilters2520;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> filter, Function<Email, String> translator, Consumer<Email> printer) {
        for (int i = 0; i < emailList.size(); i++) {
            Email email = emailList.get(i);
            if (filter.test(email)) {
                printer.accept(email);
                translator.apply(email);
            } else {
                emailList.remove(email);
                i--;
            }
        }
    }
}
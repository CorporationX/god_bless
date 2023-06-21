package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processorEmails(List<Email> emailList, Predicate<Email> filter, Consumer<Email> handler, Function<Email, String> function) {
        if (!(emailList == null) && emailList.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        assert emailList != null;
        emailList.stream().filter(filter).forEach(email -> {
            email.setBody(function.apply(email));
            handler.accept(email);
        });
    }
}

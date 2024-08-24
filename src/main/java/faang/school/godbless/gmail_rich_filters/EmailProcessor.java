package faang.school.godbless.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> predicate,
                              Consumer<Email> consumer, Function<Email, String> function) {

        for (Email email : emailList) {
            System.out.println(predicate.test(email));
        }

        emailList.forEach(consumer);

        for (Email email : emailList) {
            System.out.println(function.apply(email));
        }
    }
}

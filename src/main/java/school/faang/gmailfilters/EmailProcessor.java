package school.faang.gmailfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList,
                              Predicate<Email> filter,
                              Function<Email, String> transformer,
                              Consumer<Email> action) {
         emailList.stream()
                .filter(filter)
                .peek(transformer::apply)
                 .forEach(action);
    }

}
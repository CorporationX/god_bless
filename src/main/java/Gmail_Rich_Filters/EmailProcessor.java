package Gmail_Rich_Filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> processor, Function<Email,String> transformer){
        for(Email email: emails){

            if (filter.test(email)){
                transformer.apply(email);
                processor.accept(email);
            }

        }

    }

    public List<Email> processEmailsToNewList(List<Email> emails,
                                              Predicate<Email> filter, Consumer<Email> processor,
                                              Function<Email,String> transformer) {
        List<Email> newEmails = new ArrayList<>();
        for (Email email : emails) {
            if (filter.test(email)) {
                transformer.apply(email);
                newEmails.add(email);
                processor.accept(email);
            }
        }
        return newEmails;
    }
}

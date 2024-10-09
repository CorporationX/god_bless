package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails, Predicate<Email> predicate, Function<Email, String> convertEmail, Consumer<Email> consumer){
        List<Email> filteredEmails = new ArrayList<>();

        for(Email email : emails){
            if(predicate.test(email)){
                filteredEmails.add(email);
            }
        }

        for(Email email : filteredEmails){
            convertEmail.apply(email);

            consumer.accept(email);
        }
    }
}

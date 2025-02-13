package school.faang.BJS2_57361;

import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Setter
public class EmailProcessor {
    @NonNull
    private Predicate<Email> filter;
    @NonNull
    private Function<Email, String> converter;
    @NonNull
    private Consumer<Email> handler;

    public void processEmails(List<Email> emailList) {
        for (Email email : emailList) {
            if (filter.test(email)) {
                email.setSubject(converter.apply(email));
                handler.accept(email);
            }
        }
    }
}

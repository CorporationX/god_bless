package school.faang.gmail;

import lombok.NonNull;
import school.faang.gmail.entity.Email;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmail(@NonNull List<Email> emails, @NonNull Predicate<Email> filter,
                             @NonNull Function<Email, String> processor, Consumer<Email> handler) {
        emails.forEach(email -> {
            if (!filter.test(email)) {
                return;
            }

            email.setBody(processor.apply(email));
            handler.accept(email);
        });
    }
}

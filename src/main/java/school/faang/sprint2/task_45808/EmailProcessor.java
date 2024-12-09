package school.faang.sprint2.task_45808;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(@NonNull List<Email> letters,
                              @NonNull Predicate<Email> filter,
                              @NonNull Function<Email, String> transform,
                              @NonNull Consumer<Email> process) {
        for (Email letter : letters) {
            if (filter.test(letter)) {
                String transformedBody = transform.apply(letter);
                letter.setBody(transformedBody);
                process.accept(letter);
            }
        }
    }
}

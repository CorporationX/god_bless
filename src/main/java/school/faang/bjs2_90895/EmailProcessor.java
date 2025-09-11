package school.faang.bjs2_90895;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface EmailProcessor {
    void processEmailsWithString(List<Email> emails,
                                 Predicate<Email> filter,
                                 Function<Email, String> transformer,
                                 Consumer<Email> action);

    void processEmailsWithEmail(List<Email> emails,
                                Predicate<Email> filter,
                                Function<Email, Email> transformer,
                                Consumer<Email> action);
}

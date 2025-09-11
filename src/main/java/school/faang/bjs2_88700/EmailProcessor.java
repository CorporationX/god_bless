package school.faang.bjs2_88700;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> letters, Predicate<Email> filter,
                              Consumer<Email> processor, Function<Email, String> converter) {
        for (Email letter : letters) {
            if (filter.test(letter)) {
                letter.setBody(converter.apply(letter));
                processor.accept(letter);
            }
        }
    }
}
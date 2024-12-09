package school.faang.task_45794;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(
                List<Email> letters,
                Predicate<Email> flag,
                Function<Email, String> transform,
                Consumer<Email> process) {
        for (Email letter : letters) {
            if (flag.test(letter)) {
                String transformedBody = transform.apply(letter);
                letter.setBody(transformedBody);
                process.accept(letter);
            }
        }
    }
}

package school.faang.functional_interfaces__lambdas.bjs2_87253;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Function<Email, String> converter, Consumer<Email> action) {
        for (Email email : emails) {
            if (filter.test(email)) {
                // Об этом не подумал, увидел в подсказке, то есть преобразовал, но не зафиксировал в списке..
                String convertedBody = converter.apply(email);
                email.setBody(convertedBody);
                action.accept(email);
            }
        }
    }
}

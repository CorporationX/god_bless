package faang.school.godbless.gmailRFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> consumer, Function<Email, String> mapper) {
        validateEntity(filter, "Filter");
        validateEntity(consumer, "Consumer");
        validateEntity(mapper, "Mapper");

        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    String transformedBody = mapper.apply(email);
                    email.setBody(transformedBody);
                    consumer.accept(email);
                });
    }

    private <T> void validateEntity(T entity, String entityName) {
        if (entity == null) {
            throw new IllegalArgumentException(entityName + " can't be empty");
        }
    }
}

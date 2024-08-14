package faang.school.godbless.lambda.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> process, Function<Email, String> transform) {
        return emails.stream()
                .filter(filter)
                .map(email -> {
                    String transformedBody = transform.apply(email);
                    System.out.println("Email body after transform: " + transformedBody);
                    process.accept(email);
                    return new Email(email.getSubject(), transformedBody, email.isImportant());
                }).collect(toList());


    }
}

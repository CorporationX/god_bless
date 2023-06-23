package gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> printEmail, Function<Email, String> toUpperCase) {
        emails.stream()
                .filter(filter)
                .forEach(email -> {
                    printEmail.accept(email);
                    String convertedToUpperCase = toUpperCase.apply(email);
                    System.out.println("Converted body: " + convertedToUpperCase);
                });
    }
}

package bjs2_70467;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

public class EmailProcessor {
    public void processEmails(
            List<Email> emails,
            Predicate<Email> filter,
            Function<Email, String> converter,
            Consumer<Email> handler
    ) {
        for(Email email : emails) {
            if(filter.test(email)) {
                String convertedBody = converter.apply(email);
                email.setBody(convertedBody);
                handler.accept(email);
            } else {
                System.out.printf("Email %s does not belong to the " +
                        "appropriate category (important or not)\n", email.getSubject());
            }
        }
    }
}

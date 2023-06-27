package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void processEmails(List<Email> emails, Predicate<Email> checkEmail,
                                     Consumer<Email> processEmail,
                                     Function<Email, Email> convertEmail) {
        for (int i = 0; i < emails.size(); i++) {
            Email email = emails.get(i);
            if (checkEmail.test(email)) {
                Email converted = convertEmail.apply(email);
                emails.set(i, converted);
                processEmail.accept(converted);
            }
        }
    }
}
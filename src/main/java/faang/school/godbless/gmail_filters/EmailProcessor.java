package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static List<Email> processEmails(List<Email> emails, Predicate<Email> checkEmail,
                                            Consumer<Email> processEmail,
                                            Function<Email, Email> convertEmail) {
        return emails.stream().filter(checkEmail).peek(processEmail).map(convertEmail).toList();
    }
}
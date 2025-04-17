package school.faang.bjs2_71888;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final EmailProcessor EMAIL_PROCESSOR = new EmailProcessor();
    private static final List<Email> EMAILS = List.of(
        new Email("Important Email", "This is an important email.", true),
        new Email("Important Email", "Some email text.", true),
        new Email("Important Email", "Other email sent to us.", true),
        new Email("Normal Email", "This is a normal email.", false),
        new Email("Normal Email", "Nothing to say.", false)
    );
    // private static final Predicate<Email> IS_IMPORTANT = Email::isImportant;
    private static final Predicate<Email> IS_IMPORTANT = email -> !email.isImportant();
    private static final Consumer<Email> PRINT_EMAILS = email -> log.info(email.toString());
    private static final Function<Email, String> MODIFY_EMAIL = email -> email.getBody().toUpperCase();

    public static void main(String[] args) {
        EMAIL_PROCESSOR.processEmails(EMAILS, IS_IMPORTANT, PRINT_EMAILS, MODIFY_EMAIL);
    }
}

package faang.school.godbless.richfilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = Arrays.asList(
                new Email("Daily meeting", "body", true),
                new Email("Advertising", "body", false),
                new Email("Suggestion", "body", false)
        );

        Predicate<Email> importantFilter = Email::isImportant;
        Consumer<Email> printSubject = email -> System.out.println(email.subject());
        Function<Email, String> changeBody = email -> email.body().replaceAll("o", "a");

        emailProcessor.processEmails(emails, importantFilter, printSubject, changeBody);

    }
}

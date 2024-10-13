package school.faang.m1s2.bjs2_33546_gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emails,
                              Predicate<Email> filter,
                              Consumer<Email> printer,
                              Consumer<Email> fontModifier) {

        emails.stream()
                .filter(filter)
                .peek(fontModifier)
                .peek(printer)
                .forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));
    }
}

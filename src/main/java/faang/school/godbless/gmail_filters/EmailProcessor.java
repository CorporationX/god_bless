package faang.school.godbless.gmail_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
                             Function<Email, Email> function){
        emails.stream().filter(predicate).map(function).forEach(consumer);
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        Predicate<Email> isImportant = Email::getIsImportant;
        Function<Email, Email> toUpperCase = email -> {
            String uppercasedBody = email.getBody().toUpperCase();
            return new Email(email.getSubject(), uppercasedBody, email.getIsImportant());
        };
        Consumer<Email> printEmail = System.out::println;

        Email email1 = new Email("Super important", "important content", true);
        Email email2 = new Email("Not important", "not important content", false);

        List<Email> emailList = List.of(email1, email2);

        emailProcessor.processEmail(emailList, isImportant, printEmail, toUpperCase);
    }
}

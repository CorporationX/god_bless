package faang.school.godbless.gmail_filter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emailList = List.of(
                new Email("Mail-1", "Text of mail", true),
                new Email("Mail-2", "Text of mail 2", false),
                new Email("Mail-3", "Text of mail 3", true)
        );

        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Mail is Recevived: " + email.getSubject());

        Function<Email, Email> toUpperCase = email -> {
            email.setBody(email.getBody().toUpperCase());
            return email;
        };


        emailProcessor.processEmails(emailList, importantFilter, printEmail, toUpperCase);

    }

}

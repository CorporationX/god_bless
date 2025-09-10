package school.faang.bjs2_88588;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        ArrayList<Email> emailList = new ArrayList<>(Arrays.asList(
                new Email("Letter 1", "Hello everyone", true),
                new Email("Letter 2", "I've arrived", true),
                new Email("Spam", "You won 1 million", false)
        ));

        Predicate<Email> predicate = Email::isImportant;

        Function<Email, Email> function = email -> {
            email.getSubject().toUpperCase();
            email.setBody("%s | MAIL".formatted(email.getBody()));
            return email;
        };

        Consumer<Email> consumer = System.out::println;

        emailProcessor.processEmails(emailList, predicate, function, consumer);

        System.out.println(emailList);
    }
}

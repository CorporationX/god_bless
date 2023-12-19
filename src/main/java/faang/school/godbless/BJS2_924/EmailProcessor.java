package faang.school.godbless.BJS2_924;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public static void main(String[] args) {
        List<Email> listofEmails = new ArrayList<>();

        listofEmails.add(new Email("Letter 1", "Hello, how are you", false));
        listofEmails.add(new Email("Letter 2", "I am your dad", true));
        listofEmails.add(new Email("Letter 3", "My name is Rauan", true));

        Predicate<Email> predicate = s -> s.isImportant();
        Consumer<Email> consumer = email -> System.out.println("Letter processed: "+email.getSubject());
        Function<Email, String> function = email -> email.getBody().toLowerCase();

        processEmails(listofEmails, predicate, consumer, function);
    }

    public static void processEmails(List<Email> listOfEmails, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function){
        for (Email email : listOfEmails) {
            if (predicate.test(email)) {
                consumer.accept(email);
                System.out.println(function.apply(email));
            }else{
                System.out.println(email+" is not important message");
            }
        }
    }
}

package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emailList = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        Predicate<Email> predicate = Email::isImportant;
        Consumer<Email> consumer = (item) -> System.out.println("Письмо обработано: " + item.getBody());
        Function<Email, String> function = (item) -> item.getBody().toUpperCase();

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emailList, predicate, consumer, function);

        System.out.println(emailList);
    }
}

package school.faang.gmailfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = new ArrayList<>(List.of(
                new Email("Письмо 1", "Тут какой-то текст письма 1", true),
                new Email("Письмо 2", "Тут уже очень важное письмо", true),
                new Email("Письмо 3", "А вот и снова что-то не важное", false),
                new Email("Письмо 4", "О, расспродажа где-то в другом конце жопы мира", false),
                new Email("Письмо 5", "Скидки в стиме", true)
        ));

        Predicate<Email> predicate = Email::isImportant;
        Function<Email, Email> function = email ->
                new Email(email.subject(), email.body().toUpperCase(), email.isImportant());
        Consumer<Email> consumer = email -> System.out.println("Письмо " + email.subject() + " обработано!");

        EmailProcessor processor = new EmailProcessor();
        processor.processEmails(predicate, function, consumer, emails);

        emails.forEach(System.out::println);
    }
}

package faang.school.godbless.sprint_3.gmail_rich_filters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emails = List.of(
                new Email("Dear Friend!", "I HOPE you MISS ME because I MISS YOU SO MUCH....", true),
                new Email("Nearest neighbor", "I JUST MOVED INTO this house AnD I WaNt To invite yOu to a party!", true),
                new Email("Spam", "JOIN INTO OUR CASINO RIGHT NOW AND YOU GET 3 FREE SPINS! ", false));

        Predicate<Email> predicate = Email::isImportant;
        Consumer<Email> consumer = email -> System.out.println("Ваше письмо: " + email.getSubject() + " находится в обработке.....");
        Function<Email, Email> function = email -> new Email(email.getSubject().toUpperCase(), email.getBody().toLowerCase(), email.isImportant());

        List<Email> result = EmailProcessor.processEmails(emails, predicate, consumer, function);
        System.out.println(result);
    }
}

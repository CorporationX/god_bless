package faang.school.godbless.secondSprint.GmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emails = List.of(
                new Email("Письмо Санте", "Хочу на новый год сырную шаву", true),
                new Email("Письмо от Мамы", "Сынок, нам нечего кушать", false),
                new Email("Срочно прочтите!", "От вас зависити судьба мира, вам нужно...", false)
        );

        Predicate<Email> predicate = email -> !email.isImportant();
        Consumer<Email> consumer = email -> System.out.println("Запускаю обработку бесполезного письма: "
                + email.getBody());
        Function<Email, Email> function = email -> new Email("Spam", "", false);

        List<Email> uselessEmails = emailProcessor.processEmails(emails, predicate, consumer, function);
        uselessEmails.forEach(System.out::println);
    }
}

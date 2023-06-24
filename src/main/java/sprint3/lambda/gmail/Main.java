package sprint3.lambda.gmail;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private static final EmailProcessor EMAIL_PROCESSOR = new EmailProcessor();

    public static void main(String[] args) {
        List<Email> emails = getEmails();

        Predicate<Email> importantFilter = email -> !email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EMAIL_PROCESSOR.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }

    private static List<Email> getEmails() {
        return Arrays.asList(
                new Email("Jira: миша все...", "...переделывай", true),
                new Email("Пицца", "хачу пиццы", true),
                new Email("Деньги", "Ну как там с деньгами?", false),
                new Email("Концерт", "Новый концерт Оксимирон...", false)
        );
    }
}

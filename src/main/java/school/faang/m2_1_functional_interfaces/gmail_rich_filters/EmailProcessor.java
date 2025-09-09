package school.faang.m2_1_functional_interfaces.gmail_rich_filters;

import school.faang.m2_1_functional_interfaces.gmail_rich_filters.model.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(
            List<Email> emailList,
            Predicate<Email> filter,
            Consumer<Email> process,
            Function<Email, String> function) {
        Iterator<Email> iterator = emailList.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (filter.test(email)) {
                function.apply(email);
                process.accept(email);
                iterator.remove();
            } else {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emails = new ArrayList<>(Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        ));

        Predicate<Email> importantFilter = email -> email.isImportant();

        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

        emails.forEach(email -> System.out.println(
                "Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

    }
}

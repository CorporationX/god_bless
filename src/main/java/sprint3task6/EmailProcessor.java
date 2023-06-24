package sprint3task6;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
//настраивать фильтры для обработки входящих писем.
public class EmailProcessor {
//Predicate для фильтрации писем, Consumer для обработки писем и
//Function для преобразования писем.

    public void processEmails(List<Email> emails, Predicate<Email> filter,
                              Consumer<Email> handling,
                              Function<Email, String> converting) {

//List<Email> filteredEmails = new ArrayList();
        for (Email oneExactEmail : emails) {
//for (int i = 0; i < emails.size(); i++) {
            if (filter.test(oneExactEmail)) {
                //filteredEmails.add(emails.get(i));
                String apply1 = converting.apply(oneExactEmail);
                oneExactEmail.setBody(apply1);
                handling.accept(oneExactEmail);
//N
//изменили верхние две строчки, чтобы все-таки выводилось капсом body сообщения.
//и все-таки сначала идет функц.интерфейс Function, а потом Consumer.
//плюс см. строку 48.

            }//List <String> convertedHandledFilteredEmails = converting.apply(handledFilteredEmails);
        }
    }
    public static void main(String[] args) {

        EmailProcessor emailProcessor = new EmailProcessor();
// Создание списка входящих писем
        List<Email> emails = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
// Создание фильтров, обработчиков и преобразователей
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getBody());
//для корректной работы должен быть email.getBody() вместо email.getSubject()
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }
}

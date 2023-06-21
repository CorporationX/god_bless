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
       public void processEmails (List<Email> emails, Predicate<List<Email>> filter,
                                  Consumer<List <Email>> handling,
                                  Function<List <Email>, String> converting){
           boolean filteredEmails = filter.test(emails);
           List<Email> handledFilteredEmails = (List<Email>) handling.accept(filteredEmails);
           String convertedHandledFilteredEmails = converting.apply(handledFilteredEmails);
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
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

// Обработка писем
        emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);
    }

}

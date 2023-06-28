import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();

        List<Email> emailList = List.of(new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false));

        Predicate<Email> filterEmail = email -> email.isImportant();
        Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject() + " " + email.getBody());
        Function<Email, String> convertingEmail = email -> email.getBody().toUpperCase();

        emailProcessor.processEmails(emailList, filterEmail, printEmail, convertingEmail);
    }
}
package school.faang.gmailrichfilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestClass {
    public static void main(String[] args) {
        List<Email> emailList = Arrays.asList(
                new Email("Пословица про Сашу", "Шла Саша по шоссе и сосала сушку...", true),
                new Email("Пословица про Греку", "Ехал Грека через реку, видит грека в реке рак...", true),
                new Email("Сказка", "Посадил дед репку...", false)
        );

        System.out.println("Письма до обработки");
        emailList.forEach(System.out::println);

        Predicate<Email> importanceFilter = Email::isImportant;
        Function<Email, String> transformFilter = email -> email.getBody().replace(" ", "");
        Consumer<Email> actionFilter = email -> System.out.println("Обработано письмо: " + email.getSubject());

        System.out.println();
        var processedEmails = new EmailProcessor().processEmails(emailList, importanceFilter, transformFilter, actionFilter);

        System.out.println("\nПисьма после обработки");
        processedEmails.forEach(System.out::println);
    }
}

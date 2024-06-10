package faang.school.godbless.GmailRichFilters;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Email> emailList = Arrays.asList(
                new Email("Письмо 1", "Текст письма 1", false),
                new Email("Письмо 2", "Текст письма 2", true),
                new Email("Спам", "Текст спама", false)
        );
        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmails(emailList, Email::isImportant, (item) -> System.out.println("Письмо обработано: " + item.getBody()), (item) -> item.getBody().toUpperCase());

        System.out.println(emailList);
    }
}

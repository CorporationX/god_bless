package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    private final static List<Email> emailList = new ArrayList<>();

    public static void startEmail() {
        emailList.add(new Email("Mail 1",
                "Text mail 1", false));
        emailList.add(new Email("Mail 2",
                "Text mail 2", true));
        emailList.add(new Email("Spam",
                "Text spam", false));
        Predicate<Email> importantFilter = email -> email.isImportant();
        Consumer<Email> printMail = email -> System.out.println(email.getBody());
        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();

        EmailProcessor emailProcessor = new EmailProcessor();
        emailProcessor.processEmail(emailList, importantFilter, printMail, toUpperCase);
    }
}

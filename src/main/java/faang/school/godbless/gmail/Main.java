package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emailList = new ArrayList<>();

        Email emailFromFriend = new Email("Inviting to dinner", "Message from friend", true);
        Email emailFromWork = new Email("Realise some feature", "Message from boss", true);
        Email emailFromMarket = new Email("Inviting to black friday", "Message from store", false);
        Email emailFromHospital = new Email("Inviting to check health", "Message from hospital", true);

        emailList.add(emailFromFriend);
        emailList.add(emailFromWork);
        emailList.add(emailFromMarket);
        emailList.add(emailFromHospital);

        EmailProcessor emailProcessor = new EmailProcessor();

        Predicate<Email> isImportant = Email::isImportant;
        Consumer<Email> showRemained = email -> System.out.println("Email " + email.getSubject() + " was read");
        Function<Email, String> respondToEmails = email -> email.getSubject().toUpperCase();

        emailProcessor.processEmails(emailList, isImportant, showRemained, respondToEmails);
        for (Email email : emailList) {
            System.out.println(email);
        }
    }
}

package faang.school.godbless.GMailRichFilters2520;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Email> emailList = new ArrayList<>(List.of(
                new Email("NOT A SPAM I SWEAR", "You won 1M$. Send your CVV", false),
                new Email("Congratulations!", "You are now a Google employee", true),
                new Email("Open me", "Not_a_virus.exe", false),
                new Email("Your request is answered", "We will refund you in 3 workdays", true)));
        EmailProcessor emailProcessor = new EmailProcessor();
        Predicate<Email> filter = (email) -> email.isImportant();
        Function<Email, String> translator = (email) -> email.translate(email.getBody());
        Consumer<Email> printer = (email) -> System.out.println(email.getBody());

        emailProcessor.processEmails(emailList, filter, translator, printer);
    }
}
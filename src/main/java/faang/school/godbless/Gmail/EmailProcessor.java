package faang.school.godbless.Gmail;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> mails, Predicate<Email> filterEmails,
                              Consumer<Email> handling,
                              Function<Email, String> transformation){
        for (Email mail : mails) {
            if(filterEmails.test(mail)) {
                transformation.apply(mail);
                handling.accept(mail);
            }
        }
    }
}

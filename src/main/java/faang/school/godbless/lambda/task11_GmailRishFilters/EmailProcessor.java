package faang.school.godbless.lambda.task11_GmailRishFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public List<Email> processEmails(List<Email> emails, Predicate<Email> importantFilter, Consumer<Email> printEmail, Function<Email, String> toUpperCase){
        if (emails == null || emails.isEmpty()){
            throw new IllegalArgumentException("Email пуст");
        }
        for (Email email : emails) {
            if(importantFilter.test(email)){
                printEmail.accept(email);
                toUpperCase.apply(email);
            }
        }
        return emails;
    }
}

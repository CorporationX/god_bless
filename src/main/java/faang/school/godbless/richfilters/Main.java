package faang.school.godbless.richfilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        EmailProcessor emailProcessor = new EmailProcessor();
        List<Email> emailList = List.of(
                new Email("email 1","new subject",true),
                new Email("email 2","new subject two",false),
                new Email("email 3","new subject three",true)
        );
        Predicate<Email> filter = Email::isImportant;
        Consumer<Email> handler =(a)-> System.out.println(a.getSubject());
        Function<Email,Email> transform = email -> {
            return new Email(email.getBody(),email.getSubject().toUpperCase(),email.isImportant());
        };
        emailProcessor.processEmails(emailList,filter,handler,transform);
    }
}

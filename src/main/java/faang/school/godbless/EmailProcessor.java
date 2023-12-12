package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, Predicate<Email> importantFilter,  Consumer<Email> printEmail, Function<Email, String> toUpperCase){
        System.out.println("Входящие");
        for(Email email: emailList) {
            if(importantFilter.test(email)){
                printEmail.accept(email);
                toUpperCase.apply(email);
            }
        }
        System.out.println("Спам");
        for(Email email: emailList) {
            if(!importantFilter.test(email)){
                printEmail.accept(email);
                toUpperCase.apply(email);
            }
        }
    }

}

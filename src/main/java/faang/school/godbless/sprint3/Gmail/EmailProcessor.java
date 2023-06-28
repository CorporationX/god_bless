package faang.school.godbless.sprint3.Gmail;

import java.util.List;

public class EmailProcessor {
    public void processEmails(List<Email> listMessage, Predicate predicate, Consumer consumer,Function function){
        for (Email email : listMessage){
            if (predicate.act(email)){
                email.setBody((String) function.act(email));
                consumer.act(email);
            }
        }
    }
}

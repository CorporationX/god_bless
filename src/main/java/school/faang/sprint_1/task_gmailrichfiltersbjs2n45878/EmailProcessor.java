package school.faang.sprint_1.task_gmailrichfiltersbjs2n45878;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList,
                              Predicate<Email> predicateObj,
                              Consumer<Email> consumerObj,
                              Function<Email, String> functionObj
    ) {
        for (Email email : emailList) {
            if (predicateObj.test(email)) {
                email.setBody(functionObj.apply(email));
                consumerObj.accept(email);
            }
        }
    }
}

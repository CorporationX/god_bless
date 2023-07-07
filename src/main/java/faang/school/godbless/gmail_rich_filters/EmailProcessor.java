package faang.school.godbless.gmail_rich_filters;

import java.util.List;

public class EmailProcessor {

    public void processEmails(List<Email> emailList, EmailHandler emailHandler) {
        for (Email email : emailList) {
            emailHandler.getFilter().test(email);
            emailHandler.getProcessor().accept(email);
            email.setBody(emailHandler.getConverter().apply(email));
        }
    }
}

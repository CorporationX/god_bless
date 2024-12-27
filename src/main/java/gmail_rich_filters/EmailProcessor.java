package gmail_rich_filters;

import java.util.ArrayList;
import java.util.List;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emailList) {
        List<Email> processedList = new ArrayList<>();
        return processedList = emailList.stream().filter(Email::isImportant)
                .peek(email-> System.out.println("писмо обработано: " + email.getSubject()))
                .map(email -> new Email(email.getSubject(),email.getBody().toUpperCase(),true))
                .toList();
    }
    public void printEmails(List<Email> emailList){
        emailList.forEach(email -> System.out.printf("Email: %s сообщение: %s", email.getSubject(),email.getBody()));
    }
}
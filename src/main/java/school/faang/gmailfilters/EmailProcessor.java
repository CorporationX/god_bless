package school.faang.gmailfilters;

import java.util.List;
import java.util.stream.Collectors;

public class EmailProcessor {

    public List<Email> processEmails(List<Email> emailList) {
        return emailList.stream()
                .filter(Email::isImportant)
                .peek(email -> System.out.println("Письмо обработано: " + email.getSubject()))
                .peek(email -> email.setBody(email.getBody().toUpperCase()))
                .collect(Collectors.toList());

    }

}

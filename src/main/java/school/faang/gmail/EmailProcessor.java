package school.faang.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmailProcessor {
    public void processEmails(List<Email> emails) {
        List<Email> emailList = emails.stream().filter(Objects::nonNull)
                .filter(Email::isImportant)
                .peek(email -> email.setBody(email.getBody().toUpperCase()))
                .peek(email -> System.out.println(String.format("Message title: " + email.getSubject())))
                .toList();
        System.out.println(emailList);
    }
}
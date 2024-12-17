package school.faang.sprint2task45951;

import java.util.List;

public class EmailProcessor {
    public void processEmails(List<Email> mails) {
        mails.stream()
                .filter(Email::getIsImportant)
                .map(k -> k.getBody().toUpperCase())
                .peek(k -> System.out.println("Обработано письмо: " + k))
                .toList();
    }
}
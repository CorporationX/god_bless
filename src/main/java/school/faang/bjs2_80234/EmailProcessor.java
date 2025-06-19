package school.faang.bjs2_80234;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class EmailProcessor {
    public void processEmails(List<Email> emailList,
                              Predicate<Email> filter,
                              Function<Email, String> bodyTransformer,
                              Consumer<Email> emailConsumer) {
        if (emailList == null || emailList.isEmpty()) {
            log.info("Лист равен null");
            return;
        }

        Iterator<Email> iterator = emailList.iterator();
        while (iterator.hasNext()) {
            Email email = iterator.next();
            if (!filter.test(email)) {
                iterator.remove();
            }
        }

        for (Email email : emailList) {
            String newBody = bodyTransformer.apply(email);
            email.setBody(newBody);
            System.out.println(newBody);
            emailConsumer.accept(email);
        }
    }
}

package school.faang.bjs2_88588;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(ArrayList<Email> emailList, Predicate<Email> predicate,
                              Function<Email, Email> function, Consumer<Email> consumer) {

        ArrayList<Email> listForRemove = new ArrayList<>();
        emailList.forEach(email -> {
            boolean resultPredicate = predicate.test(email);
            if (resultPredicate) {
                function.apply(email);
                consumer.accept(email);
            } else {
                listForRemove.add(email);
            }
        });

        System.out.printf("Letters to delete %s \n", listForRemove);
    }
}

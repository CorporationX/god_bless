package school.faang.bjs2_88588;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmails(ArrayList<Email> emailList,
                              Predicate<Email> predicate,
                              Function<Email, Email> function,
                              Consumer<Email> consumer) {

        List<Email> listForRemove = new ArrayList<>();
        emailList.forEach(email -> {
            boolean resultPredicate = predicate.test(email);
            if (resultPredicate) {
                function.apply(email);
                consumer.accept(email);
            } else {
                listForRemove.add(email);
            }
        });
        emailList.removeAll(listForRemove);
        System.out.printf("Letters to delete %s \n", listForRemove);
    }
}

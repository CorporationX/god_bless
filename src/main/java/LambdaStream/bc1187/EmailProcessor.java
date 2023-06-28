package LambdaStream.bc1187;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public void processEmails(List<Email> emailList, Predicate<Email> predicate, Consumer<Email> consumer, Function<Email, String> function) {
//        for (Email email : emailList) {
//            if (predicate.test(email)) {
//                String res = function.apply(email);
//                email.setBody(res);
//                consumer.accept(email);
//            }
//        }

        emailList.stream()
                .filter(predicate)
                .forEach(email -> {
                    String functionResult = function.apply(email);
                    email.setBody(functionResult);
                    consumer.accept(email);
                });
    }
}

package faang.school.godbless.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

    public void processEmail(List<Email> emailList, Predicate<Email> importanceСheck, Consumer<Email> textOutput, Function<Email, String> textFormatting) {
        emailList.forEach(email -> {
            if (importanceСheck.test(email)) {
                email.setBody(textFormatting.apply(email));
                textOutput.accept(email);
            }
            else{
                textOutput.accept(email);
            }

        });
    }
}

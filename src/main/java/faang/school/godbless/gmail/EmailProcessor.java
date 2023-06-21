package faang.school.godbless.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
  public void processEmails(List<Email> emails, Predicate<Email> filterPredicate, Consumer<Email> handleFn, Function<Email, String> emailTransformer) {
    emails.forEach(email -> {
      filterPredicate.test(email);
      handleFn.accept(email);
      emailTransformer.apply(email);
    });
  }
}

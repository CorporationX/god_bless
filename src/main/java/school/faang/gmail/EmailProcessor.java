package school.faang.gmail;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

  void processEmails(List<Email> emails, Predicate<Email> filter,
      Function<Email, String> transform,
      Consumer<Email> handle) {
    emails.forEach(email -> {
      if (filter.test(email)) {
        String transformedBody = transform.apply(email);
        email.setBody(transformedBody);
        handle.accept(email);
      }
    });
  }

}

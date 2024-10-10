package school.faang.gmailRichFilters;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
  public void processEmails(List<Email> emails, Predicate<Email> predicate, Function<Email, String> function, Consumer<Email> consumer) {
    emails.forEach(email -> {
      if(email != null && predicate.test(email)) {
        email.setBody(function.apply(email));
        consumer.accept(email);
      }
    });
  }
}

package school.faang.godbless.bjs2_33520;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {

  public void processEmails(List<Email> emails, Predicate<Email> filter, Function<Email, String> bodyChanger,
      Consumer<Email> mailProcessor) {
    emails.stream().filter(filter).forEach(e -> {
      e.setBody(bodyChanger.apply(e));
      mailProcessor.accept(e);
    });
  }
}

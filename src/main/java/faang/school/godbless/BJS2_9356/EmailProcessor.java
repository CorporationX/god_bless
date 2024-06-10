package faang.school.godbless.BJS2_9356;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
  public void processEmails(List<Email> emails, Predicate<Email> filter,
    Consumer<Email> processing, Function<Email, String> transform) {
    List<String> filterEmails = emails.stream().filter(filter).peek(processing).map(transform).toList();
  }
}

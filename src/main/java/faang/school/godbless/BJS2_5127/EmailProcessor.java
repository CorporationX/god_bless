package faang.school.godbless.BJS2_5127;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
  public List<String> processEmails(List<Email> emails, Predicate<Email> predicate, Consumer<Email> consumer,
    Function<Email, String> function) {
    return emails.stream()
      .filter(predicate)
      .peek(consumer)
      .map(function)
      .toList();
  }
}

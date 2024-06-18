package faang.school.godbless.bjs2_11847;

import faang.school.godbless.ColorScheme;
import java.util.List;
import java.util.Random;

public record PersonNamePrinter(List<Person> persons) implements Runnable {
  private static final String WORKPLACE = " Место работы: ";

  @Override
  public void run() {
    final int id = new Random().nextInt(ColorScheme.values().length);
    persons.forEach(person -> System.out.println(ColorScheme.findByID(id) +
            Thread.currentThread().getName() + WORKPLACE + person.workplace()));
  }
}

package faang.school.godbless.bjs2_11847;

import static faang.school.godbless.ColorScheme.RESET;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int POOL_SIZE = 5;
  private static final int TIME_OUT = 30;
  private static final int COUNT_PERSON = 10_000;
  private static final int MIN_VALUE = 1;
  private static final String PROGRAM_OPERATION_COMPLETE = "Работа программы завершена";
  private static final String ID = "id = ";
  private static final String EMPTY_VALUE = " ";

  public static void main(String[] args) {
    final List<Person> persons = new ArrayList<>();
    for (int i = 0; i < COUNT_PERSON;) {
      persons.add(new Person(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
          new Random().nextInt(), ID + ++i + EMPTY_VALUE + UUID.randomUUID().toString()));
    }
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    final int  subPoolSize = COUNT_PERSON / POOL_SIZE;
    for (int i = 0; i < POOL_SIZE; i++) {
      final var subPerson = persons.subList(getStartIndex(i, subPoolSize), getEndIndex(i, subPoolSize));
      executorService.submit(new PersonNamePrinter(subPerson));
    }

    executorService.shutdown();
    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(RESET.getColor() + PROGRAM_OPERATION_COMPLETE);
  }

  private static int getStartIndex(int index, int subPoolSize)  {
    return index * subPoolSize;
  }

  private static int getEndIndex(int index, int subPoolSize)  {
    return (index + MIN_VALUE) * subPoolSize;
  }

}

package faang.school.godbless.colleges;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
  private static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int PERSONS_COUNT = 100;
  private static final int PERSONS_CHUNK_LENGTH = (int) Math.ceil((double) PERSONS_COUNT / PROCESSORS_COUNT);

  public static void main(String[] args) throws InterruptedException {
    List<Person> persons = IntStream.rangeClosed(0,  PERSONS_COUNT)
        .boxed().map(num -> new Person(num.toString())).toList();

    ExecutorService service = Executors.newFixedThreadPool(PROCESSORS_COUNT);

    processChunkedPrinting(persons, service);

    service.shutdown();

    boolean isTasksCompleted = service.awaitTermination(5, TimeUnit.SECONDS);

    if (isTasksCompleted) {
      System.out.println("Finished");
    }

  }

  private static void processChunkedPrinting(List<Person> persons, ExecutorService service) {
    for (int i = 0; i < PROCESSORS_COUNT; i++) {
      int startIndex = i * PERSONS_CHUNK_LENGTH;
      int endIndex = startIndex + PERSONS_CHUNK_LENGTH;

      if (endIndex > persons.size() - 1) {
        endIndex = persons.size() - 1;
      }

      PersonNamePrinter personNamePrinter = new PersonNamePrinter(persons.subList(startIndex, endIndex));
      service.submit(personNamePrinter);
    }
  }
}

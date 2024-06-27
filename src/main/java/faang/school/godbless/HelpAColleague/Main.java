package faang.school.godbless.HelpAColleague;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int COUNT_THREAD = 10;
    private static final int COUNT_PERSONS = 100;
    private static final int COUNT_PERSONS_IN_ONE_THREAD = COUNT_PERSONS / COUNT_THREAD;

    public static void main(String[] args) {
        List<Person> people = createPersons(COUNT_PERSONS);
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);
        for (int i = 0; i < COUNT_THREAD; i++) {
            int start = i * COUNT_PERSONS_IN_ONE_THREAD;
            int end = start + COUNT_PERSONS_IN_ONE_THREAD;
            people.subList(start, end).forEach(a -> executorService.submit(new PersonNamePrinter(a)));
        }
        executorService.shutdown();
    }

    private static List<Person> createPersons(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Person("AA - " + i, "aa - " + i, i, "a - " + i))
                .toList();
    }
}

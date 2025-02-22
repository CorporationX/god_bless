package school.faang.task_60889;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> persons;
    private final AtomicInteger counter;
    private final int subListIndex;
    private final int subListSize;

    @Override
    public void run() {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            synchronized (counter) {
                while (counter.get() != subListIndex * subListSize + i) {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        log.info("Thread {} was interrupted.", Thread.currentThread().getName());
                    }
                }
                log.info("Person: Name={}, Surname={}, Age={}, Workplace={}",
                        person.getName(), person.getSurname(), person.getAge(), person.getWorkplace());
                counter.incrementAndGet();
                counter.notifyAll();
            }
        }
    }
}

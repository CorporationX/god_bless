package school.faang.godbless.bjs2_35973;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PersonInfoPrinter implements Runnable {
    private final List<Person> workers;

    public PersonInfoPrinter(@NonNull List<Person> workers) {
        this.workers = workers;
    }

    @Override
    public void run() {
        workers.forEach(worker -> log.info("{}", worker));
    }
}

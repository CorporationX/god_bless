package module_3.module_3_1_Parallelism_Thread.helpColleague_35959;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private final List<Person> batch;

    @Override
    public void run() {
        batch.forEach(System.out::println);
    }
}

package school.faang.help_the_colleague;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Slf4j
public class Main {
    private static final List<Person> people = new ArrayList<>();
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++){
            people.add(new Person("Name" + i, "Surname" + i, 25 + (i % 50), "Workplace" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        int batchSize = people.size()/THREAD_POOL_SIZE;
        for(int i = 0; i < THREAD_POOL_SIZE; i++){
            int start = i * batchSize;
            int end = (i == THREAD_POOL_SIZE - 1) ? people.size() : (i+1) * batchSize;
            List<Person> batch = people.subList(start, end);
            executor.submit(new PersonInfoPrinter(batch));
        }
        executor.shutdown();
        try {
            if(executor.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("All the tasks have been finished");
            }else{
                System.out.println("Was not able to finish all the tasks");
            }
        } catch (InterruptedException e) {
            log.error("Exception in threads connected to awaitTermination() level", e);
            e.printStackTrace();
        }
    }
}

package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();
    private static final List<Person> PERSON_LIST = createPersons(1000);
    private static final int PERSONS_CHUNK_SIZE = (int) Math.ceil((double) PERSON_LIST.size() / PROCESSORS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(PROCESSORS_COUNT);
        processPersonListChunks(executorService);
        executorService.shutdown();
        boolean isFinished = executorService.awaitTermination(10, TimeUnit.SECONDS);
        if (isFinished){
            System.out.println("Task completed");
        }
    }

    private static void processPersonListChunks(ExecutorService executorService){
        for (int i = 0; i < PROCESSORS_COUNT; i++) {
            int start = i * PERSONS_CHUNK_SIZE;
            int end = (i + 1) * PERSONS_CHUNK_SIZE;

            if (i == PROCESSORS_COUNT - 1) {
                end = PERSON_LIST.size();
            }

            List<Person> batch = PERSON_LIST.subList(start, end);
            executorService.submit(new PersonNamePrinter(batch));
        }
    }

    private static List<Person> createPersons(int quantity){
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            list.add(new Person(Integer.toString(i)));
        }

        return list;
    }
}

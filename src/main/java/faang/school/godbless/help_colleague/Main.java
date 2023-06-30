package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PROCESSORS_COUNT = Runtime.getRuntime().availableProcessors();
    private static  List<Person> personList = createPersons(1000);
    private static final int chunkSize = (int) Math.ceil((double) personList.size() / PROCESSORS_COUNT);

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
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;

            if (i == PROCESSORS_COUNT - 1) {
                end = personList.size();
            }

            List<Person> batch = personList.subList(start, end);
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
